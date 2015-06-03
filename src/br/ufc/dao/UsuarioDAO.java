package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IUsuarioDAO;
import br.ufc.model.Funcao;
import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Usuario usuario) {
		this.manager.persist(usuario);
		
	}

	@Override
	public void remover(Usuario usuario) {
		this.manager.remove(this.manager.getReference(Usuario.class, usuario.getIdUsuario()));
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		this.manager.merge(usuario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario retorna(Usuario usuario) {
		String consulta = "select u from Usuario u where u.login like :login";
		Query query = this.manager.createQuery(consulta);
		query.setParameter("login", usuario.getLogin());
		
		List<Usuario> list = query.getResultList();
		
		if(list.size() == 0) return null;
		else return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios =
				this.manager.createQuery("select u from Usuario u").getResultList();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarioFuncao(Funcao funcao){
		
		String consulta = "select u from Usuario u inner join fetch u.listaFuncao f where f.idFuncao = :id order by u.nome";
		Query query = this.manager.createQuery(consulta);
		query.setParameter("id", funcao.getIdFuncao());
		
		List<Usuario> usuarios = query.getResultList();
		
		return usuarios;
				
	}

}

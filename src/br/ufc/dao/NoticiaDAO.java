package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.INoticiaDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Repository
public class NoticiaDAO implements INoticiaDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Noticia noticia) {
		this.manager.persist(noticia);
		
	}

	@Override
	public void remover(Noticia noticia) {
		String consulta = "delete from Noticia where idNoticia = :noticia";
		Query query = this.manager.createQuery(consulta);
		query.setParameter("noticia", noticia.getIdNoticia());
		query.executeUpdate();
	}

	@Override
	public void atualizar(Noticia noticia) {
		this.manager.merge(noticia);
		
	}

	@Override
	public Noticia retorna(Noticia noticia) {
		return this.manager.find(Noticia.class, noticia.getIdNoticia());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> listar() {
		List<Noticia> noticias = 
				this.manager.createQuery("select n from Notica n").getResultList();
		return noticias;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> listarNoticiaUsuario(Usuario usuario) {
		String consulta = "select n from Noticia n where autor = :jornalista";
		Query query = this.manager.createQuery(consulta);
		query.setParameter("jornalista", usuario.getIdUsuario());
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> listarNoticiaSecao(Secao secao) {
		String consulta = "select n from Noticia n where secao = :sec";
		Query query = this.manager.createQuery(consulta);
		query.setParameter("sec", secao.getIdSecao());
		
		return query.getResultList();
	}

}

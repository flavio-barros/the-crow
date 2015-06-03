package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IComentarioDAO;
import br.ufc.model.Comentario;

@Repository
public class ComentarioDAO implements IComentarioDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Comentario comentario) {
		this.manager.persist(comentario);
		
	}

	@Override
	public void remover(Comentario comentario) {
		this.manager.remove(this.manager.getReference(Comentario.class, comentario.getIdComentario()));
		
	}

	@Override
	public void atualizar(Comentario comentario) {
		this.manager.merge(comentario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> listar() {
		List<Comentario> comentarios = 
				this.manager.createQuery("select c from Comentario").getResultList();
		return comentarios;
	}

	@Override
	public Comentario retorna(Comentario comentario) {
		return this.manager.find(Comentario.class, comentario.getIdComentario());
	}

}

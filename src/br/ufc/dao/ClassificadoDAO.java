package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IClassificadoDAO;
import br.ufc.model.Classificado;

@Repository
public class ClassificadoDAO implements IClassificadoDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Classificado classificado) {
		this.manager.persist(classificado);
		
	}

	@Override
	public void remover(Classificado classificado) {
		this.manager.remove(this.manager.getReference(Classificado.class, classificado.getIdClassificado()));
		
	}

	@Override
	public void atualizar(Classificado classificado) {
		this.manager.merge(classificado);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classificado> listar() {
		List<Classificado> classificados = 
				this.manager.createQuery("select c from Classificado c order by tituloClassificado").getResultList();
		return classificados;
	}

	@Override
	public Classificado retorna(Classificado classificado) {
		return this.manager.find(Classificado.class, classificado.getIdClassificado());
	}

}

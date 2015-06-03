package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.ISecaoDAO;
import br.ufc.model.Secao;

@Repository
public class SecaoDAO implements ISecaoDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Secao secao) {
		this.manager.persist(secao);
		
	}

	@Override
	public void remover(Secao secao) {
		this.manager.remove(this.manager.getReference(Secao.class, secao.getIdSecao()));
		
	}

	@Override
	public void atualizar(Secao secao) {
		this.manager.merge(secao);
		
	}

	@Override
	public Secao retorna(Secao secao) {
		return this.manager.find(Secao.class, secao.getIdSecao());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Secao> listar() {
		List<Secao> secoes =
				this.manager.createQuery("select s from Secao s order by tituloSecao").getResultList();
		return secoes;
	}

}

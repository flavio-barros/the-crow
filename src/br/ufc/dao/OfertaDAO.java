package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IOfertaDAO;
import br.ufc.model.Oferta;

@Repository
public class OfertaDAO implements IOfertaDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Oferta oferta) {
		this.manager.persist(oferta);
		
	}

	@Override
	public void remover(Oferta oferta) {
		this.manager.remove(this.manager.getReference(Oferta.class, oferta.getIdOferta()));
		
	}

	@Override
	public void atualizar(Oferta oferta) {
		this.manager.merge(oferta);
		
	}

	@Override
	public Oferta retorna(Oferta oferta) {
		return this.manager.find(Oferta.class, oferta.getIdOferta());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Oferta> listar() {
		List<Oferta> ofertas =
				this.manager.createQuery("select o from Oferta o").getResultList();
		return ofertas;
	}

}

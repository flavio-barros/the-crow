package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IFuncaoDAO;
import br.ufc.model.Funcao;

@Repository
public class FuncaoDAO implements IFuncaoDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionar(Funcao funcao) {
		this.manager.persist(funcao);
		
	}

	@Override
	public void remover(Funcao funcao) {
		this.manager.remove(this.manager.getReference(Funcao.class, funcao.getIdFuncao()));
		
	}

	@Override
	public void atualizar(Funcao funcao) {
		this.manager.merge(funcao);
		
	}

	@Override
	public Funcao retorna(Funcao funcao) {
		return this.manager.find(Funcao.class, funcao.getIdFuncao());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcao> listar() {
		List<Funcao> funcoes = 
				this.manager.createQuery("select f from Funcao f").getResultList();
		return funcoes;
	}

}

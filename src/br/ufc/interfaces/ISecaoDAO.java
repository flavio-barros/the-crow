package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Secao;

public interface ISecaoDAO {
	
	public void adicionar(Secao secao);
	public void remover(Secao secao);
	public void atualizar(Secao secao);
	public Secao retorna(Secao secao);
	public List<Secao> listar();

}

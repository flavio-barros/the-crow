package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Funcao;

public interface IFuncaoDAO {
	
	public void adicionar(Funcao funcao);
	public void remover(Funcao funcao);
	public void atualizar(Funcao funcao);
	public Funcao retorna(Funcao funcao);
	public List<Funcao> listar();

}

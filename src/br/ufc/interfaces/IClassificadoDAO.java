package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Classificado;

public interface IClassificadoDAO {
	
	public void adicionar(Classificado classificado);
	public void remover(Classificado classificado);
	public void atualizar(Classificado classificado);
	public Classificado retorna(Classificado classificado);
	public List<Classificado> listar();

}

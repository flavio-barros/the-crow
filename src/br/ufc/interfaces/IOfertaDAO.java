package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Oferta;

public interface IOfertaDAO {
	
	public void adicionar(Oferta oferta);
	public void remover(Oferta oferta);
	public void atualizar(Oferta oferta);
	public Oferta retorna(Oferta oferta);
	public List<Oferta> listar();

}

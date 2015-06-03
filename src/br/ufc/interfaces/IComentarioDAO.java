package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Comentario;

public interface IComentarioDAO {
	
	public void adicionar(Comentario comentario);
	public void remover(Comentario comentario);
	public void atualizar(Comentario comentario);
	public Comentario retorna(Comentario comentario);
	public List<Comentario> listar();

}

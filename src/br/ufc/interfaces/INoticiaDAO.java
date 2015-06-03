package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

public interface INoticiaDAO {
	
	public void adicionar(Noticia noticia);
	public void remover(Noticia noticia);
	public void atualizar(Noticia noticia);
	public Noticia retorna(Noticia noticia);
	public List<Noticia> listar();
	public List<Noticia> listarNoticiaUsuario(Usuario usuario);
	public List<Noticia> listarNoticiaSecao(Secao secao);

}

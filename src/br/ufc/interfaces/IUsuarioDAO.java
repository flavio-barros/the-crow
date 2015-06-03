package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Funcao;
import br.ufc.model.Usuario;

public interface IUsuarioDAO {
	
	public void adicionar(Usuario usuario);
	public void remover(Usuario usuario);
	public void atualizar(Usuario usuario);
	public Usuario retorna(Usuario usuario);
	public List<Usuario> listar();
	public List<Usuario> listarUsuarioFuncao(Funcao funcao);

}

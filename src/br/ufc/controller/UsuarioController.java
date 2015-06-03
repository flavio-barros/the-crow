package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IUsuarioDAO;
import br.ufc.model.Funcao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioDAO dao;
	
	@RequestMapping("cadastroLeitorForm")
	public String cadastrarLeitorForm(){
		return "leitor/cadastrar_leitor";
	}
	
	@RequestMapping("cadastroJornalistaForm")
	public String cadastrarJornalistaForm(Model model){
		model.addAttribute("jornalistas", this.listarJornalistas());
		return "editor/cadastrar_jornalista";
	}
	
	@RequestMapping("cadastroLeitor")
	public String cadastrarLeitor(Usuario usuario){
		List<Funcao> funcaoLeitor;
		funcaoLeitor = new ArrayList<Funcao>();
		funcaoLeitor.add(new Funcao(1));
		usuario.setListaFuncao(funcaoLeitor);
		this.dao.adicionar(usuario);
		return "redirect:paginaInicial";
	}
	
	@RequestMapping("cadastroJornalista")
	public String cadastrarJornalista(Usuario usuario){
		List<Funcao> funcaoJornalista;
		funcaoJornalista = new ArrayList<Funcao>();
		funcaoJornalista.add(new Funcao(2));
		usuario.setListaFuncao(funcaoJornalista);
		this.dao.adicionar(usuario);
		return "redirect:cadastroJornalistaForm";
	}
	
	public List<Usuario> listarJornalistas(){
		List<Usuario> jornalistas;
		jornalistas = this.dao.listarUsuarioFuncao(new Funcao(2));		
		return jornalistas;
	}

}

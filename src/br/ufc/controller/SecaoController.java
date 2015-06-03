package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.ISecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	private ISecaoDAO dao;
	
	@RequestMapping("cadastroCategoriaForm")
	public String cadastroCategoriaForm(Model model){
		model.addAttribute("secoes",this.listarSecoes());
		return "editor/cadastrar_secao";
	}
	
	@RequestMapping("cadastroCategoria")
	public String cadastroCategoria(Secao secao){
		this.dao.adicionar(secao);
		return "redirect:cadastroCategoriaForm";
	}
	
	@RequestMapping("carregarCategorias")
	public String carregarCategorias(Model model){
		List<Secao> secoes;
		secoes = this.dao.listar();
		model.addAttribute("secoes", secoes);
		return "redirect:paginaInicial";
	}
	
	@RequestMapping("noticiasCategoria")
	public String noticasCategoria(Secao secao, Model model){
		Secao s = this.dao.retorna(secao);
		model.addAttribute("noticias", s.getNoticias());
		model.addAttribute("secao", s);
		return "noticia/visualizar_noticia_secao";
	}
	
	public List<Secao> listarSecoes(){
		List<Secao> secoes;
		secoes = this.dao.listar();		
		return secoes;
	}
}

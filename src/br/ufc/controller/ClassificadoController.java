package br.ufc.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IClassificadoDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Oferta;

@Transactional
@Controller
public class ClassificadoController {
	
	@Autowired
	private IClassificadoDAO dao;
	
	@RequestMapping("cadastroClassificadoForm")
	public String cadastrarLeitorForm(){
		return "editor/cadastrar_classificado";
	}
	
	@RequestMapping("visualizarClassificados")
	public String visualizarClassificados(Model model){
		model.addAttribute("classificados", this.listarClassificados());
		return "classificado/visualizar_classificados";
	}
	
	@RequestMapping("cadastroClassificado")
	public String cadastrarClassificado(Classificado classificado){
		System.out.println(classificado);
		this.dao.adicionar(classificado);
		return "redirect:visualizarClassificados";
	}
	
	@RequestMapping("detalhesClassificados")
	public String visualizarDetalhesClassificados(Classificado classificado, Model model){
		Classificado c = this.dao.retorna(classificado);
		model.addAttribute("classificado", c);
		if(c.getOfertas().isEmpty())
			model.addAttribute("melhorOferta", null);
		else{
			Collections.sort((List<Oferta>) c.getOfertas());
			model.addAttribute("melhorOferta",((List<Oferta>)c.getOfertas()).get(0));
		}
		return "classificado/visualizar_detalhes_classificado";
	}
	
	public List<Classificado> listarClassificados(){
		List<Classificado> classificados = this.dao.listar();
		return classificados;
	}
}

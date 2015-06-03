package br.ufc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.INoticiaDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Transactional
@Controller
public class NoticiaController {
	
	@Autowired
	private INoticiaDAO dao;
	
	@Autowired
	private SecaoController sController;
	
	@RequestMapping("cadastroNoticiasForm")
	public String cadastrarNoticiaForm(Model model){
		model.addAttribute("secoes", this.sController.listarSecoes());
		return "jornalista/cadastrar_noticia";
	}
	
	@RequestMapping("cadastroNoticias")
	public String cadastrarNotica(Noticia noticia){
		noticia.setData(new Date());
		this.dao.adicionar(noticia);
		return "redirect:cadastroNoticiasForm";
	}
	
	@RequestMapping("visualizarNoticia")
	public String visualizarNoticia(Noticia noticia, Model model){
		model.addAttribute("noticia", this.dao.retorna(noticia));
		return "noticia/visualizar_noticia";
	}
	
	//método para apagar noticia, executado pela página "Listar noticia por Seção"
	@RequestMapping("apagarNoticiaNS")
	public String apagarNoticiaNS(Noticia noticia, Secao secao){
		this.dao.remover(noticia);
		return "redirect:noticiasCategoria?idSecao="+secao.getIdSecao();
	}
	
	//método para apagar noticia, executado pela página "Listar noticia por Seção"
	@RequestMapping("apagarNoticiaPI")
	public String apagarNoticiaPI(Noticia noticia, Secao secao){
		this.dao.remover(noticia);
		return "redirect:paginaInicial";
	}

}

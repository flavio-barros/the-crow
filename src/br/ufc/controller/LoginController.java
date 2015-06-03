package br.ufc.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IUsuarioDAO;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioDAO dao;
	
	@Autowired
	private SecaoController sController;
	
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session){
		System.out.println(usuario);
		Usuario u = dao.retorna(usuario);
		System.out.println(usuario);
		if(u == null){
			return "redirect:paginaInicial";
		}else{
			if(!(usuario.getLogin().equals(u.getLogin()))){
				return "redirect:paginaInicial";
			}else if(!(usuario.getSenha().equals(u.getSenha()))){
				return "redirect:paginaInicial";
			}
		}
		session.setAttribute("logado", u);
		return "redirect:paginaInicial";
	}
	
	@RequestMapping("logout")
	public String invalidate(HttpSession session){
		session.invalidate();
		return "redirect:paginaInicial";
	}
	
	@RequestMapping("paginaInicial")
	public String paginaInicial(Model model){
		model.addAttribute("secoes", this.sController.listarSecoes());
		return "index";
	}
}
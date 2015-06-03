package br.ufc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IOfertaDAO;
import br.ufc.model.Oferta;

@Transactional
@Controller
public class OfertaController {
	
	@Autowired
	private IOfertaDAO dao;
	
	@RequestMapping("cadastroOferta")
	public String cadastrarOferta(Oferta oferta){
		oferta.setData(new Date());
		System.out.println(oferta);
		this.dao.adicionar(oferta);
		return "redirect:detalhesClassificados?idClassificado="+oferta.getClassificado().getIdClassificado();
	}
}

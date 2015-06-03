package br.ufc.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classificado")
public class Classificado {
	
	@Id
	@GeneratedValue
	@Column(name="id_classificado")
	private int idClassificado;
	@Column(name="titulo_classificado")
	private String tituloClassificado;
	@Column(name="texto_classificado")
	private String textoClassificado;
	@Column(name="preco_inicial")
	private double precoInicial;
	private String telefone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="classificado",targetEntity=Oferta.class,fetch=FetchType.EAGER)
	private Collection<Oferta> ofertas;
	
	public Classificado() {
		
	}

	public Classificado(int idClassificado, String tituloClassificado,
			String textoClassificado, double precoInicial, String telefone) {
		
		this.idClassificado = idClassificado;
		this.tituloClassificado = tituloClassificado;
		this.textoClassificado = textoClassificado;
		this.precoInicial = precoInicial;
		this.telefone = telefone;
	}

	public Collection<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(Collection<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public int getIdClassificado() {
		return idClassificado;
	}

	public void setIdClassificado(int idClassificado) {
		this.idClassificado = idClassificado;
	}

	public String getTituloClassificado() {
		return tituloClassificado;
	}

	public void setTituloClassificado(String tituloClassificado) {
		this.tituloClassificado = tituloClassificado;
	}

	public String getTextoClassificado() {
		return textoClassificado;
	}

	public void setTextoClassificado(String textoClassificado) {
		this.textoClassificado = textoClassificado;
	}

	public double getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(double precoInicial) {
		this.precoInicial = precoInicial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Classificado [idClassificado=" + idClassificado
				+ ", tituloClassificado=" + tituloClassificado
				+ ", textoClassificado=" + textoClassificado
				+ ", precoInicial=" + precoInicial + ", telefone=" + telefone
				+ "]";
	}
	
}

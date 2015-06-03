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
@Table(name="secao")
public class Secao {
	
	@Id
	@GeneratedValue
	@Column(name="id_secao")
	private Long idSecao;
	@Column(name="titulo_secao")
	private String tituloSecao;
	@Column(name="descricao_secao")
	private String descricaoSecao;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="secao",targetEntity=Noticia.class,fetch=FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	public Secao() {
		
	}
	
	public Secao(Long idSecao, String tituloSecao, String descricaoSecao) {
		
		this.idSecao = idSecao;
		this.tituloSecao = tituloSecao;
		this.descricaoSecao = descricaoSecao;
	}

	public Collection<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public String getTituloSecao() {
		return tituloSecao;
	}

	public void setTituloSecao(String tituloSecao) {
		this.tituloSecao = tituloSecao;
	}

	public String getDescricaoSecao() {
		return descricaoSecao;
	}

	public void setDescricaoSecao(String descricaoSecao) {
		this.descricaoSecao = descricaoSecao;
	}

	@Override
	public String toString() {
		return "Secao [idSecao=" + idSecao + ", tituloSecao=" + tituloSecao
				+ ", descricaoSecao=" + descricaoSecao + "]";
	}

}

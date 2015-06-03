package br.ufc.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="noticia")
public class Noticia {
	
	@Id
	@GeneratedValue
	@Column(name="id_noticia")
	private int idNoticia;
	
	@Column(name="titulo_noticia")
	private String tituloNoticia;
	
	@Column(name="subtitulo_noticia")
	private String subtituloNoticia;
	
	@Column(name="texto_noticia")
	private String textoNoticia;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_secao",referencedColumnName="id_secao")
	private Secao secao;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario",referencedColumnName="id_usuario")
	private Usuario autor;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="noticia",targetEntity=Comentario.class,fetch=FetchType.EAGER)
	private Collection<Comentario> comentarios;
	
	public String getSubtituloNoticia() {
		return subtituloNoticia;
	}

	public void setSubtituloNoticia(String subtituloNoticia) {
		this.subtituloNoticia = subtituloNoticia;
	}

	public Collection<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Noticia() {
		
	}

	public Noticia(int idNoticia, String tituloNoticia,
			String subTituloNoticia, String textoNoticia, Date data,
			Secao secao, Usuario autor) {
		
		this.idNoticia = idNoticia;
		this.tituloNoticia = tituloNoticia;
		this.subtituloNoticia = subTituloNoticia;
		this.textoNoticia = textoNoticia;
		this.data = data;
		this.secao = secao;
		this.autor = autor;
	}
	
	

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTituloNoticia() {
		return tituloNoticia;
	}

	public void setTituloNoticia(String tituloNoticia) {
		this.tituloNoticia = tituloNoticia;
	}

	public String getTextoNoticia() {
		return textoNoticia;
	}

	public void setTextoNoticia(String textoNoticia) {
		this.textoNoticia = textoNoticia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", tituloNoticia="
				+ tituloNoticia + ", subTituloNoticia=" + subtituloNoticia
				+ ", textoNoticia=" + textoNoticia + ", data=" + data
				+ ", secao=" + secao + ", autor=" + autor + "]";
	}
	
}

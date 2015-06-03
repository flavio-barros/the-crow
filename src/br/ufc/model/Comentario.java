package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario {
	
	@Id
	@GeneratedValue
	@Column(name="id_comentario")
	private int idComentario;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_noticia",referencedColumnName="id_noticia")
	private Noticia noticia;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario",referencedColumnName="id_usuario")
	private Usuario leitor;
	@Column(name="texto_comentario")
	private String textoComentario;
	
	public Comentario() {
		
	}

	public Comentario(int idComentario, Noticia noticia, Usuario leitor,
			String textoComentario) {
		
		this.idComentario = idComentario;
		this.noticia = noticia;
		this.leitor = leitor;
		this.textoComentario = textoComentario;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Usuario getLeitor() {
		return leitor;
	}

	public void setLeitor(Usuario leitor) {
		this.leitor = leitor;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", noticia="
				+ noticia + ", leitor=" + leitor + ", textoComentario="
				+ textoComentario + "]";
	}
	
}

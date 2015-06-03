package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="oferta")
public class Oferta implements Comparable<Oferta>{
	
	@Id
	@GeneratedValue
	@Column(name="id_oferta")
	private int idOferta;
	@Temporal(TemporalType.DATE)
	private Date data;
	private Long valor;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_usuario",referencedColumnName="id_usuario")
	private Usuario usuario;
	@ManyToOne(optional=false)
	@JoinColumn(name="id_classificado",referencedColumnName="id_classificado")
	private Classificado classificado;
	
	public Oferta() {
		
	}

	public Oferta(int idOferta, Date data, Long valor, Usuario usuario,
			Classificado classificado) {
		super();
		this.idOferta = idOferta;
		this.data = data;
		this.valor = valor;
		this.usuario = usuario;
		this.classificado = classificado;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Classificado getClassificado() {
		return classificado;
	}

	public void setClassificado(Classificado classificado) {
		this.classificado = classificado;
	}

	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", data=" + data + ", usuario="
				+ usuario + ", classificado=" + classificado + "]";
	}

	@Override
	public int compareTo(Oferta o) {
		if(this.valor < o.getValor())
			return 1;
		if(this.valor > o.getValor())
			return -1;
		return 0;
	}
	
}

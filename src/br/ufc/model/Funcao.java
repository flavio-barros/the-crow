package br.ufc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcao")
public class Funcao {
	
	@Id
	@GeneratedValue
	@Column(name="id_funcao")
	private int idFuncao;
	@Column(name="titulo_funcao")
	private String tituloFuncao;
	
	public Funcao() {
		
	}
	
	public Funcao(int idFuncao) {
		this.idFuncao = idFuncao;
	}

	public Funcao(int idFuncao, String tituloFuncao) {	
		this.idFuncao = idFuncao;
		this.tituloFuncao = tituloFuncao;
	}

	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}

	public String getTituloFuncao() {
		return tituloFuncao;
	}

	public void setTituloFuncao(String tituloFuncao) {
		this.tituloFuncao = tituloFuncao;
	}

	@Override
	public String toString() {
		return "Funcao [idFuncao=" + idFuncao + ", tituloFuncao="
				+ tituloFuncao + "]";
	}

}

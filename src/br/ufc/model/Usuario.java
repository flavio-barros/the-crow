package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private Long idUsuario;
	@Column(unique=true)
	private String login;
	private String nome;
	private String senha;
	private String email;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_funcao",
			joinColumns=
	            @JoinColumn(name="id_usuario", referencedColumnName="id_usuario"),
	        inverseJoinColumns=
	            @JoinColumn(name="id_funcao", referencedColumnName="id_funcao")
	)
	private List<Funcao> listaFuncao;
	
	public Usuario() {
		
	}	

	public Usuario(String login, String nome, String senha,
			String email, List<Funcao> listaFuncao) {
		super();
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.listaFuncao = listaFuncao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUusario) {
		this.idUsuario = idUusario;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Funcao> getListaFuncao() {
		return listaFuncao;
	}

	public void setListaFuncao(List<Funcao> listaFuncao) {
		this.listaFuncao = listaFuncao;
	}

	@Override
	public String toString() {
		return "Usuario [idUusario=" + idUsuario + ", login=" + login
				+ ", nome=" + nome + ", senha=" + senha + ", email=" + email
				+ ", listaFuncao=" + listaFuncao + "]";
	}

	
	
	
}

package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Pessoa implements IdentifierInterface, Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4315472922850937518L;
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataNascimento;
	private String usuario;
	private String senha;
	private Endereco endereco;
	
	public Pessoa(Endereco endereco)
	{
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [id="
				+ id
				+ ", "
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (telefone != null ? "telefone=" + telefone + ", " : "")
				+ (dataNascimento != null ? "dataNascimento=" + dataNascimento
						+ ", " : "") + "]";
	}
	
	
}

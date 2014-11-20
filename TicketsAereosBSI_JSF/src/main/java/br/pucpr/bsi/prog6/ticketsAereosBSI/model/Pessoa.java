package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(sequenceName="SEQ_ID_USUARIO", 
name="seqIdUsuario", initialValue=0, 
allocationSize=1)


public abstract class Pessoa implements IdentifierInterface, Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1847715757862584652L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,
	generator="seqIdUsuario")

	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataNascimento;
	private String usuario;
	private String senha;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	public Pessoa(Endereco endereco)
	{
		this.endereco = endereco;
	}
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
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
				+ (nome != null ? "nome=" + nome + ", " : "")+ "]";
	}

	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass()!= getClass())
			return false;
		if (((IdentifierInterface)obj).getId() != id)
			return false;		
		return true;
	}
	
	
	
}

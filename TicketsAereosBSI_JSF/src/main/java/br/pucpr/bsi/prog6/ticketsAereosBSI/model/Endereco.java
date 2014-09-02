package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco implements IdentifierInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3950091640940508510L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	
	private Long id;
	private String rua;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Endereco [id="
				+ id
				+ ", "
				+ (rua != null ? "rua=" + rua + ", " : "")
				+ "numero="
				+ numero
				+ ", "
				+ (complemento != null ? "complemento=" + complemento + ", "
						: "")
				+ (bairro != null ? "bairro=" + bairro + ", " : "")
				+ (cidade != null ? "cidade=" + cidade + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (pais != null ? "pais=" + pais : "") + "]";
	}
	
	
}

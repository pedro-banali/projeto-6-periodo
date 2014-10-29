package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarPassageiroMB.FILTRO_PESQUISA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarPassageiroMB.PASSAGEIRO_SELECIONADO;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;




import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ManterPassageiroMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterPassageiroMB.class);
	
	private Passageiro passageiro = new Passageiro(new Endereco());
	private Passageiro filtroPesquisa;
	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterPassageiroMB() {
	}
	
	@PostConstruct
	private void init(){
		
		
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		
		
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			
			
			
			passageiro = (Passageiro) ViewUtil.getParameter(PASSAGEIRO_SELECIONADO);
			if(passageiro == null){
				throw new TicketsAereosBSIException("ER0102");
			}
			log.debug("Valor do Passageior:" + passageiro);
			filtroPesquisa = (Passageiro) ViewUtil.getParameter(FILTRO_PESQUISA);
			log.debug("Valor do Filtro:" + filtroPesquisa);
		} else  {
			acao = Acoes.INCLUIR;
		}
	}	
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	
	//Action de Salvar Usuario
	public String salvar() {
		if(isAcaoIncluir()){
			PassageiroBC.getInstance().insert(this.passageiro);
		} else if(isAcaoEditar()){
			PassageiroBC.getInstance().update(this.passageiro);
		} else if(isAcaoExcluir()){
			PassageiroBC.getInstance().delete(this.passageiro);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarPassageiro";
	}
	
	//Action para reset do cadastro
	public void limpar() {
		this.passageiro = new Passageiro(new Endereco());
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	
	public boolean isAcaoEditar(){
		return Acoes.EDITAR.equals(acao);
	}
	
	public boolean isAcaoExcluir(){
		return Acoes.EXCLUIR.equals(acao);
	}	
	
	public boolean isAcaoIncluir(){
		return Acoes.INCLUIR.equals(acao);
	}

	public boolean isAcaoVisualizar(){
		return Acoes.VISUALIZAR.equals(acao);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	
	

	public String getTitle(){
		switch(acao){
			case EDITAR:
				return MessagesUtils.getLabel("editarPassageiro");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirPassageiro");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirPassageiro");
			case VISUALIZAR:
				return MessagesUtils.getLabel("visualizarPassageiro");
		}
		return "";
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Passageiro getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Passageiro filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	public Acoes getAcao() {
		return acao;
	}

	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
}
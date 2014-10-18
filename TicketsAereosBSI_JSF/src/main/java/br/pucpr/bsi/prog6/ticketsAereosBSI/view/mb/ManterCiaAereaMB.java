package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarCiaAereaMB.CIAAEREA_SELECIONADA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarCiaAereaMB.FILTRO_PESQUISA;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ManterCiaAereaMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterCiaAereaMB.class);
	
	private CiaAerea ciaAerea = new CiaAerea();
	private CiaAerea filtroPesquisa;
	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterCiaAereaMB() {
	}
	
	@PostConstruct
	private void init(){
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			ciaAerea = (CiaAerea) ViewUtil.getParameter(CIAAEREA_SELECIONADA);
			if(ciaAerea == null){
				throw new TicketsAereosBSIException("ER0052");
			}
			log.debug("Valor do CiaAerea:" + ciaAerea);
			filtroPesquisa = (CiaAerea) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			CiaAereaBC.getInstance().insert(this.ciaAerea);
		} else if(isAcaoEditar()){
			CiaAereaBC.getInstance().update(this.ciaAerea);
		} else if(isAcaoExcluir()){
			CiaAereaBC.getInstance().delete(this.ciaAerea);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarCiaAerea";
	}
	
	//Action para reset do cadastro
	public void limpar() {
		ciaAerea = new CiaAerea();
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
	
	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}
	
	public void setAviao(CiaAerea aviao) {
		this.ciaAerea = aviao;
	}
	
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	
	public String getTitle(){
		switch(acao){
			case EDITAR:
				return MessagesUtils.getLabel("editarCiaAerea");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirCiaAerea");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirCiaAerea");
			case VISUALIZAR:
				return MessagesUtils.getLabel("visualizarCiaAerea");
		}
		return null;
	}
}
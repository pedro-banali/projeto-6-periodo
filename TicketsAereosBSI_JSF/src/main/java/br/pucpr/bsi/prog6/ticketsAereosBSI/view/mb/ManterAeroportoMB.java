package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarAeroportoMB.FILTRO_PESQUISA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarAeroportoMB.AEROPORTO_SELECIONADO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ManterAeroportoMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterAeroportoMB.class);
	
	private Aeroporto aeroporto = new Aeroporto(new Endereco());
	private Aeroporto filtroPesquisa;
	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterAeroportoMB() {
	}
	
	@PostConstruct
	private void init(){
		
		
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		
		
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			
			
			
			aeroporto = (Aeroporto) ViewUtil.getParameter(AEROPORTO_SELECIONADO);
			if(aeroporto == null){
				throw new TicketsAereosBSIException("ER0013");
			}
			log.debug("Valor do Aeroporto:" + aeroporto);
			filtroPesquisa = (Aeroporto) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			AeroportoBC.getInstance().insert(this.aeroporto);
		} else if(isAcaoEditar()){
			AeroportoBC.getInstance().update(this.aeroporto);
		} else if(isAcaoExcluir()){
			AeroportoBC.getInstance().delete(this.aeroporto);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarAeroporto";
	}
	
	//Action para reset do cadastro
	public void limpar() {
		this.aeroporto = new Aeroporto(new Endereco());
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
	
	
	
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	
	public Aeroporto getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(Aeroporto Aeroporto) {
		this.aeroporto = Aeroporto;
	}

	public Aeroporto getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Aeroporto filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}


	public String getTitle(){
		switch(acao){
			case EDITAR:
				return MessagesUtils.getLabel("editarAeroporto");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirAeroporto");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirAeroporto");
			case VISUALIZAR:
				return MessagesUtils.getLabel("visualizarAeroporto");
		}
		return "";
	}
}
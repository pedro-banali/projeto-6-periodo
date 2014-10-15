package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarPapelMB.FILTRO_PESQUISA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarPapelMB.PAPEL_SELECIONADO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

@ManagedBean
@ViewScoped
public class ManterPapelMB {

	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterAviaoMB.class);
	
	private Papel papel = new Papel(new CiaAerea());
	private List<CiaAerea> companhiasAereas;
	private Papel filtroPesquisa;
	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterPapelMB() {
	}
	
	@PostConstruct
	private void init(){
		
		companhiasAereas = CiaAereaBC.getInstance().findAll();
		
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		
		
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			
			
			
			papel = (Papel) ViewUtil.getParameter(PAPEL_SELECIONADO);
			if(papel == null){
				throw new TicketsAereosBSIException("ER0052");
			}
			log.debug("Valor do Aviao:" + papel);
			filtroPesquisa = (Papel) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			PapelBC.getInstance().insert(this.papel);
		} else if(isAcaoEditar()){
			PapelBC.getInstance().update(this.papel);
		} else if(isAcaoExcluir()){
			PapelBC.getInstance().delete(this.papel);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarAviao";
	}
	
	//Action para reset do cadastro
	public void limpar() {
		this.papel = new Papel(new CiaAerea());
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
	
	public Papel getPapel() {
		return papel;
	}
	
	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	
	public List<CiaAerea> getCompanhiasAereas() {
		return companhiasAereas;
	}

	public void setCompanhiasAereas(List<CiaAerea> companhiasAereas) {
		this.companhiasAereas = companhiasAereas;
	}

	public String getTitle(){
		switch(acao){
			case EDITAR:
				return MessagesUtils.getLabel("editarPapel");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirPapel");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirPapel");
			case VISUALIZAR:
		}
		return null;
	}
	
}

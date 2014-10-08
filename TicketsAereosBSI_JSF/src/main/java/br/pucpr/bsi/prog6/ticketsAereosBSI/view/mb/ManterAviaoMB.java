package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.List;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarAviaoMB.AVIAO_SELECIONADA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarAviaoMB.FILTRO_PESQUISA;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ManterAviaoMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterAviaoMB.class);
	
	private Aviao aviao = new Aviao(new CiaAerea());
	private List<CiaAerea> companhiasAereas;
	private Aviao filtroPesquisa;
	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterAviaoMB() {
	}
	
	@PostConstruct
	private void init(){
		
		companhiasAereas = CiaAereaBC.getInstance().findAll();
		
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		
		
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			
			
			
			aviao = (Aviao) ViewUtil.getParameter(AVIAO_SELECIONADA);
			if(aviao == null){
				throw new TicketsAereosBSIException("ER0052");
			}
			log.debug("Valor do Aviao:" + aviao);
			filtroPesquisa = (Aviao) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			AviaoBC.getInstance().insert(this.aviao);
		} else if(isAcaoEditar()){
			AviaoBC.getInstance().update(this.aviao);
		} else if(isAcaoExcluir()){
			AviaoBC.getInstance().delete(this.aviao);
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
		this.aviao = new Aviao(new CiaAerea());
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
	
	public Aviao getAviao() {
		return aviao;
	}
	
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
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
				return MessagesUtils.getLabel("editarAviao");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirAviao");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirAviao");
			case VISUALIZAR:
		}
		return null;
	}
}
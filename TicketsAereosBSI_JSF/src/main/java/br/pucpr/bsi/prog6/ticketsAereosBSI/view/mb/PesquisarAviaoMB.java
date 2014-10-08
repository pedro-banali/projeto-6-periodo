package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
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
public class PesquisarAviaoMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String AVIAO_SELECIONADA = "aviaoSelecionada";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarAviaoMB.class);
	
	private Aviao filtroPesquisa;
	
	private List<Aviao> avioes;
	private Aviao aviaoSelecionada;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarAviaoMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (Aviao) ViewUtil.getParameter(FILTRO_PESQUISA);
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if(filtroPesquisa == null){
			this.filtroPesquisa = new Aviao(new CiaAerea());
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		avioes = AviaoBC.getInstance().findByFilter(filtroPesquisa);
		if(avioes.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterAviaoMB.Acoes.EDITAR);
		return "manterAviao";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterAviaoMB.Acoes.EXCLUIR);
		return "manterAviao";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterAviaoMB.Acoes.VISUALIZAR);
		return "manterAviao";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	private void validate(){
		if(aviaoSelecionada == null){
			throw new TicketsAereosBSIException("ER0052");
		}
	}
	
	private void setParameters(ManterAviaoMB.Acoes acao){
		ViewUtil.setRequestParameter(AVIAO_SELECIONADA, aviaoSelecionada);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(acao);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public Aviao getFiltroPesquisa() {
		return filtroPesquisa;
	}
	
	public List<Aviao> getAvioes() {
		return avioes;
	}
	
	public Aviao getAviaoSelecionada() {
		return aviaoSelecionada;
	}
	
	public void setCiaAereaSelecionada(Aviao selecionada) {
		aviaoSelecionada = selecionada;
	}
}
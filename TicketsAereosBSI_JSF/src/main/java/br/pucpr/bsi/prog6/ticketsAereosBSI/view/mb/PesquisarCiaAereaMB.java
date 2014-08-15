package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBCC;
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
public class PesquisarCiaAereaMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String CIAAEREA_SELECIONADA = "ciaAereaSelecionada";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarCiaAereaMB.class);
	
	private CiaAerea filtroPesquisa;
	
	private List<CiaAerea> ciaAereas;
	private CiaAerea ciaAereaSelecionada;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarCiaAereaMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (CiaAerea) ViewUtil.getParameter(FILTRO_PESQUISA);
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if(filtroPesquisa == null){
			filtroPesquisa = new CiaAerea();
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		ciaAereas = CiaAereaBCC.getInstance().findByFilter(filtroPesquisa);
		if(ciaAereas.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterCiaAereaMB.Acoes.EDITAR);
		return "manterCiaAerea";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterCiaAereaMB.Acoes.EXCLUIR);
		return "manterCiaAerea";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterCiaAereaMB.Acoes.VISUALIZAR);
		return "manterCiaAerea";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	private void validate(){
		if(ciaAereaSelecionada == null){
			throw new TicketsAereosBSIException("ER0052");
		}
	}
	
	private void setParameters(ManterCiaAereaMB.Acoes acao){
		ViewUtil.setRequestParameter(CIAAEREA_SELECIONADA, ciaAereaSelecionada);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(acao);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public CiaAerea getFiltroPesquisa() {
		return filtroPesquisa;
	}
	
	public List<CiaAerea> getCiaAereas() {
		return ciaAereas;
	}
	
	public CiaAerea getCiaAereaSelecionada() {
		return ciaAereaSelecionada;
	}
	
	public void setCiaAereaSelecionada(CiaAerea selecionada) {
		ciaAereaSelecionada = selecionada;
	}
}
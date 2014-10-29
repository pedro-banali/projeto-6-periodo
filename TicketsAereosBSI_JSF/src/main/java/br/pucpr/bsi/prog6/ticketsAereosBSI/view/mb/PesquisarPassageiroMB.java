package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

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
public class PesquisarPassageiroMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String PASSAGEIRO_SELECIONADO = "passageiroSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarPassageiroMB.class);
	
	private Passageiro filtroPesquisa;
	
	private List<Passageiro> passageiros;
	private Passageiro passageiroSelecionado;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarPassageiroMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (Passageiro) ViewUtil.getParameter(FILTRO_PESQUISA);
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if(filtroPesquisa == null){
			this.filtroPesquisa = new Passageiro(new Endereco());
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		passageiros = PassageiroBC.getInstance().findByFilter(filtroPesquisa);
		if(passageiros == null || passageiros.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterPassageiroMB.Acoes.EDITAR);
		return "manterPassageiro";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterPassageiroMB.Acoes.EXCLUIR);
		return "manterPassageiro";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterPassageiroMB.Acoes.VISUALIZAR);
		return "manterPassageiro";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	
	
	private void validate(){
		if(passageiroSelecionado == null){
			throw new TicketsAereosBSIException("ER0102");
		}
	}
	
	public List<Passageiro> getPassageiros() {
		return passageiros;
	}
	
	
	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public Passageiro getPassageiroSelecionado() {
		return passageiroSelecionado;
	}

	public void setPassageiroSelecionado(Passageiro passageiroSelecionado) {
		this.passageiroSelecionado = passageiroSelecionado;
	}

	public void setFiltroPesquisa(Passageiro filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	private void setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterPassageiroMB.Acoes editar){
		ViewUtil.setRequestParameter(PASSAGEIRO_SELECIONADO, passageiroSelecionado);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(editar);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public Passageiro getFiltroPesquisa() {
		return filtroPesquisa;
	}
	

	
	
}
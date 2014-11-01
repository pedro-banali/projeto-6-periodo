package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class PesquisarAeroportoMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String AEROPORTO_SELECIONADO = "aeroportoSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarAeroportoMB.class);
	
	private Aeroporto filtroPesquisa;
	private List<Aeroporto> aeroportos;
	private Aeroporto aeroportoSelecionado;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////

	@PostConstruct
	private void init(){
		filtroPesquisa = (Aeroporto) ViewUtil.getParameter(FILTRO_PESQUISA);
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if(filtroPesquisa == null){
			this.filtroPesquisa = new Aeroporto(new Endereco());
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		System.out.println("Maaaaaahhhhh oeewww");
		aeroportos = AeroportoBC.getInstance().findByFilter(filtroPesquisa);
		if(aeroportos == null || aeroportos.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
		System.out.println("Maaaaaahhhhh oeewww");
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterAeroportoMB.Acoes.EDITAR);
		return "manterAeroporto";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterAeroportoMB.Acoes.EXCLUIR);
		return "manterAeroporto";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterAeroportoMB.Acoes.VISUALIZAR);
		return "manterAeroporto";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	
	
	private void validate(){
		if(aeroportoSelecionado == null){
			throw new TicketsAereosBSIException("ER0013");
		}
	}
	
	

	public void setAeroportos(List<Aeroporto> aeroportos) {
		this.aeroportos = aeroportos;
	}

	public Aeroporto getAeroportoSelecionado() {
		return aeroportoSelecionado;
	}

	public void setAeroportoelecionado(Aeroporto aeroportoSelecionado) {
		this.aeroportoSelecionado = aeroportoSelecionado;
	}

	public void setFiltroPesquisa(Aeroporto filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	private void setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterAeroportoMB.Acoes editar){
		ViewUtil.setRequestParameter(AEROPORTO_SELECIONADO, aeroportoSelecionado);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(editar);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public Aeroporto getFiltroPesquisa() {
		return filtroPesquisa;
	}
	
	public List<Aeroporto> getAeroportos() {
		return aeroportos;
	}
	public void setAeroportoSelecionado(Aeroporto aeroportoSelecionado) {
		this.aeroportoSelecionado = aeroportoSelecionado;
	}
		
	
}
package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class PesquisarRotaMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String ROTA_SELECIONADA = "rotaSelecionada";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarRotaMB.class);
	
	private Rota filtroPesquisa;
	private List<Rota> rotas;
	private Rota rotaSelecionada;
	private List<Aeroporto> origens;
	private List<Aeroporto> destinos;
	private List<CiaAerea> ciaAereas;
	
	
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarRotaMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (Rota) ViewUtil.getParameter(FILTRO_PESQUISA);
		log.debug("Valor do Filtro:" + filtroPesquisa);
		origens = AeroportoBC.getInstance().findAll();
		destinos = AeroportoBC.getInstance().findAll();
		ciaAereas = CiaAereaBC.getInstance().findAll();
		if(filtroPesquisa == null){
			filtroPesquisa = new Rota(new CiaAerea(), new Aeroporto(new Endereco()),new Aeroporto(new Endereco()));
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		if(filtroPesquisa.getDestino() == null){
			filtroPesquisa.setDestino(new Aeroporto(new Endereco()));
		}
		if(filtroPesquisa.getOrigem() == null){
			filtroPesquisa.setOrigem(new Aeroporto(new Endereco()));
		}
		if(filtroPesquisa.getCiaAerea() == null){
			filtroPesquisa.setCiaAerea(new CiaAerea());
		}
		rotas = RotaBC.getInstance().findByFilter(filtroPesquisa);
		if(rotas.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterRotaMB.Acoes.EDITAR);
		return "manterRota";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterRotaMB.Acoes.EXCLUIR);
		return "manterRota";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterRotaMB.Acoes.VISUALIZAR);
		return "manterRota";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	private void validate(){
		if(rotaSelecionada == null){
			throw new TicketsAereosBSIException("ER0123");
		}
	}
	
	private void setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterRotaMB.Acoes acao){
		ViewUtil.setRequestParameter(ROTA_SELECIONADA, rotaSelecionada);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(acao);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public Rota getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Rota filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}


	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}

	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}

	public List<Aeroporto> getOrigens() {
		return origens;
	}

	public void setOrigens(List<Aeroporto> origens) {
		this.origens = origens;
	}

	public List<Aeroporto> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Aeroporto> destinos) {
		this.destinos = destinos;
	}

	public List<CiaAerea> getCiaAereas() {
		return ciaAereas;
	}

	public void setCiaAereas(List<CiaAerea> ciaAereas) {
		this.ciaAereas = ciaAereas;
	}
	
	
}
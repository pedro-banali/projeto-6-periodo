package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarRotaMB.ROTA_SELECIONADA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarRotaMB.FILTRO_PESQUISA;

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
public class ManterRotaMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterRotaMB.class);
	
	private Rota rota = new Rota( new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
	private Rota filtroPesquisa;
	private Acoes acao = Acoes.INCLUIR;
	private List<Aeroporto> origens;
	private List<Aeroporto> destinos;
	private List<CiaAerea> ciaAereas;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterRotaMB() {
	}
	
	@PostConstruct
	private void init(){
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		origens = AeroportoBC.getInstance().findAll();
		destinos = AeroportoBC.getInstance().findAll();
		ciaAereas = CiaAereaBC.getInstance().findAll();
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			rota = (Rota) ViewUtil.getParameter(ROTA_SELECIONADA);
			if(rota == null){
				throw new TicketsAereosBSIException("ER0123");
			}
			log.debug("Valor do Rota:" + rota);
			filtroPesquisa = (Rota) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			RotaBC.getInstance().insert(this.rota);
		} else if(isAcaoEditar()){
			RotaBC.getInstance().update(this.rota);
		} else if(isAcaoExcluir()){
			RotaBC.getInstance().delete(this.rota);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarRota";
	}
	
	//Action para reset do cadastro
	public void limpar() {
		rota = new Rota( new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
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
	
	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Rota getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Rota filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
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

	public String getTitle(){
		switch(acao){
			case EDITAR:
				return MessagesUtils.getLabel("editarRota");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirRota");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirRota");
			case VISUALIZAR:
				return MessagesUtils.getLabel("visualizarRota");
		}
		return null;
	}
}
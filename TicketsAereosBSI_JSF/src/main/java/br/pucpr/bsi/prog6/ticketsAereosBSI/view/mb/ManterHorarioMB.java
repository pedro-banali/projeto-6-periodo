package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarHorarioMB.FILTRO_PESQUISA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarHorarioMB.HORARIO_SELECIONADO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ManterHorarioMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterHorarioMB.class);
	
	private Horario horario = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
	private List<CiaAerea> companhiasAereas;
	private List<Rota> rotas;
	private List<Aviao> avioes;
	private Horario filtroPesquisa;

	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterHorarioMB() {
	}
	
	@PostConstruct
	private void init(){
		
		companhiasAereas = CiaAereaBC.getInstance().findAll();
		
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		
		
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			
		
			horario = (Horario) ViewUtil.getParameter(HORARIO_SELECIONADO);
			listarRotas();
			listarAvioes();
			if(horario == null){
				throw new TicketsAereosBSIException("ER0052");
			}
			filtroPesquisa = (Horario) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			HorarioBC.getInstance().insert(this.horario);
		} else if(isAcaoEditar()){
			HorarioBC.getInstance().update(this.horario);
		} else if(isAcaoExcluir()){
			HorarioBC.getInstance().delete(this.horario);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarHorario";
	}
	
	public void listarRotas()
	{
		rotas = RotaBC.getInstance().findByFilter(horario.getRota());
	}
	
	public void listarAvioes()
	{
		horario.getAviao().setCiaAerea(horario.getRota().getCiaAerea());
		avioes = AviaoBC.getInstance().findByFilter(horario.getAviao());
	}
	
	//Action para reset do cadastro
	public void limpar() {
		this.horario = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
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
	
	public boolean isDisable(){
		if(Acoes.VISUALIZAR.equals(acao) || Acoes.EXCLUIR.equals(acao)){
			return true;
		}else{
			return false;
		}
	}
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	
	
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	

	public Horario getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Horario filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
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
				return MessagesUtils.getLabel("editarHorario");
			case EXCLUIR:
				return MessagesUtils.getLabel("excluirHorario");
			case INCLUIR:
				return MessagesUtils.getLabel("incluirHorario");
			case VISUALIZAR:
				return MessagesUtils.getLabel("visualizarHorario");
		}
		return null;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	public List<Aviao> getAvioes() {
		return avioes;
	}

	public void setAvioes(List<Aviao> avioes) {
		this.avioes = avioes;
	}

	public Acoes getAcao() {
		return acao;
	}


}
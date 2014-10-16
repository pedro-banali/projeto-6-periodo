package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarFuncionarioMB.FILTRO_PESQUISA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.PesquisarFuncionarioMB.FUNCIONARIO_SELECIONADO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.FuncionarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ManterFuncionarioMB implements Serializable{
	
	public enum Acoes {
		EDITAR, EXCLUIR, INCLUIR, VISUALIZAR;
	}
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ManterFuncionarioMB.class);
	
	private Funcionario funcionario = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
	private List<CiaAerea> companhiasAereas;
	private List<Papel> papeis;
	private Funcionario filtroPesquisa;
	
	private Acoes acao = Acoes.INCLUIR;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ManterFuncionarioMB() {
	}
	
	@PostConstruct
	private void init(){
		
		companhiasAereas = CiaAereaBC.getInstance().findAll();
		
		acao = (Acoes) ViewUtil.getParameter(Acoes.class);
		
		
		if(acao != null && !Acoes.INCLUIR.equals(acao)){
			
			
			
			funcionario = (Funcionario) ViewUtil.getParameter(FUNCIONARIO_SELECIONADO);
			if(funcionario == null){
				throw new TicketsAereosBSIException("ER0052");
			}
			log.debug("Valor do Funcionario:" + funcionario);
			filtroPesquisa = (Funcionario) ViewUtil.getParameter(FILTRO_PESQUISA);
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
			FuncionarioBC.getInstance().insert(this.funcionario);
		} else if(isAcaoEditar()){
			FuncionarioBC.getInstance().update(this.funcionario);
		} else if(isAcaoExcluir()){
			FuncionarioBC.getInstance().delete(this.funcionario);
		}
		MessagesUtils.addInfo("sucesso", "IN0000");
		return voltar();
	}
	
	public String voltar(){
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		return "pesquisarFuncionario";
	}
	
	//Action para reset do cadastro
	public void limpar() {
		this.funcionario = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	public void listarPapeis()
	{
		papeis = PapelBC.getInstance().findByFilter(funcionario.getPapel());
	}
	
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
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public Funcionario getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Funcionario filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	public List<CiaAerea> getCompanhiasAereas() {
		return companhiasAereas;
	}

	public void setCompanhiasAereas(List<CiaAerea> companhiasAereas) {
		this.companhiasAereas = companhiasAereas;
	}

	public String getTitle(){
//		switch(acao){
//			case EDITAR:
//				return MessagesUtils.getLabel("editarFuncionario");
//			case EXCLUIR:
//				return MessagesUtils.getLabel("excluirFuncionario");
//			case INCLUIR:
//				return MessagesUtils.getLabel("incluirFuncionario");
//			case VISUALIZAR:
//		}
		return "";
	}
}
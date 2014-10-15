package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

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
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterFuncionarioMB.Acoes;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class PesquisarFuncionarioMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String FUNCIONARIO_SELECIONADO = "funcionarioSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarFuncionarioMB.class);
	
	private Funcionario filtroPesquisa;
	
	private List<Funcionario> funcionarios;
	private List<Papel> papeis;
	private List<CiaAerea> ciaAereas;
	private Funcionario funcionarioSelecionado;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarFuncionarioMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (Funcionario) ViewUtil.getParameter(FILTRO_PESQUISA);
		ciaAereas = CiaAereaBC.getInstance().findAll();
		//setPapeis(PapelBC.getInstance().findAll());
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if(filtroPesquisa == null){
			this.filtroPesquisa = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		funcionarios = FuncionarioBC.getInstance().findByFilter(filtroPesquisa);
		if(funcionarios.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterFuncionarioMB.Acoes.EDITAR);
		return "manterFuncionario";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterFuncionarioMB.Acoes.EXCLUIR);
		return "manterAviao";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterFuncionarioMB.Acoes.VISUALIZAR);
		return "manterAviao";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	
	
	private void validate(){
		if(funcionarioSelecionado == null){
			throw new TicketsAereosBSIException("ER0052");
		}
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void listarPapeis()
	{
		papeis = PapelBC.getInstance().findByFilter(filtroPesquisa.getPapel());
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public void setFiltroPesquisa(Funcionario filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	private void setParameters(Acoes editar){
		ViewUtil.setRequestParameter(FUNCIONARIO_SELECIONADO, funcionarioSelecionado);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(editar);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public Funcionario getFiltroPesquisa() {
		return filtroPesquisa;
	}
	
	public List<Funcionario> getAvioes() {
		return funcionarios;
	}
	

	public List<CiaAerea> getCiaAereas() {
		return ciaAereas;
	}

	public void setCiaAereas(List<CiaAerea> ciaAereas) {
		this.ciaAereas = ciaAereas;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
}
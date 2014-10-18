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
	private Papel papel;
	private Papel filtroPapel;
	private CiaAerea ciaAerea;

	private Funcionario funcionarioSelecionado;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarFuncionarioMB() {
	}
	
	@PostConstruct
	private void init() {
		filtroPesquisa = (Funcionario) ViewUtil.getParameter(FILTRO_PESQUISA);
		ciaAereas = CiaAereaBC.getInstance().findAll();
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if (filtroPesquisa == null) {
			this.filtroPesquisa = new Funcionario(new Endereco(), new Papel(
					new CiaAerea()));
		} else {
			if (filtroPesquisa.getPapel().getCiaAerea().getNome() != null){
				if (filtroPesquisa.getPapel().getNome() != null){
					filtroPapel = filtroPesquisa.getPapel();
					ciaAerea = filtroPesquisa.getPapel().getCiaAerea();
					filtroPesquisa.setPapel(new Papel(ciaAerea));
					//filtroPesquisa.getPapel().setCiaAerea(ciaAerea);
				}
				papeis = PapelBC.getInstance().findByFilter(filtroPesquisa.getPapel());
				if (filtroPapel != null)
				{
					filtroPesquisa.setPapel(filtroPapel);
					//filtroPapel = null;
				}
				
				
			}
			pesquisar();
		}
	}

	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		PesquisarFuncionarioMB.log = log;
	}

	public Papel getFiltroPapel() {
		return filtroPapel;
	}

	public void setFiltroPapel(Papel filtroPapel) {
		this.filtroPapel = filtroPapel;
	}

	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}

	public void setCiaAerea(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		if (filtroPapel != null) {

			if (filtroPesquisa.getPapel().getCiaAerea().getId() != filtroPapel
					.getCiaAerea().getId()) {
				ciaAerea = filtroPesquisa.getPapel().getCiaAerea();
				filtroPesquisa.setPapel(new Papel(ciaAerea));
			}

			if (filtroPapel.getNome() != "") {
				filtroPesquisa.setPapel(filtroPapel);
			}
		}

		funcionarios = FuncionarioBC.getInstance().findByFilter(filtroPesquisa);
		if (funcionarios.isEmpty()) {
			this.filtroPesquisa.setPapel(new Papel(new CiaAerea()));
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
		return "manterFuncionario";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterFuncionarioMB.Acoes.VISUALIZAR);
		return "manterFuncionario";
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

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	
	public void setarPapel() {
		CiaAerea ciaAerea;
		ciaAerea = filtroPesquisa.getPapel().getCiaAerea();
		if(papel != null)
		{
			papel.setCiaAerea(ciaAerea);
			this.filtroPesquisa.setPapel(papel);
		}
	}
	
	
}
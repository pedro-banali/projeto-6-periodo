package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterPapelMB.Acoes;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

@ManagedBean
@ViewScoped
public class PesquisarPapelMB {
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	public static final String PAPEL_SELECIONADO = "papelSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarPapelMB.class);
	
	private Papel filtroPesquisa;
	
	private List<Papel> papeis;
	private List<CiaAerea> ciaAereas;
	private Papel papelSelecionado;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public PesquisarPapelMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (Papel) ViewUtil.getParameter(FILTRO_PESQUISA);
		ciaAereas = CiaAereaBC.getInstance().findAll();
		log.debug("Valor do Filtro:" + filtroPesquisa);
		if(filtroPesquisa == null){
			this.filtroPesquisa = new Papel(new CiaAerea());
		} else {
			pesquisar();
		}
	}
	
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		papeis = PapelBC.getInstance().findByFilter(filtroPesquisa);
		if(papeis.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public String editar(){
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterPapelMB.Acoes.EDITAR);
		return "manterPapel";
	}
	
	public String excluir(){
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterPapelMB.Acoes.EXCLUIR);
		return "manterPapel";
	}
	
	public String visualizar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterPapelMB.Acoes.VISUALIZAR);
		return "manterPapel";
	}
	
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	
	private void validate(){
		if(papelSelecionado == null){
			throw new TicketsAereosBSIException("ER0052");
		}
	}
	
	private void setParameters(Acoes editar){
		ViewUtil.setRequestParameter(PAPEL_SELECIONADO, papelSelecionado);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(editar);
	}

	public Papel getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Papel filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	public List<CiaAerea> getCiaAereas() {
		return ciaAereas;
	}

	public void setCiaAereas(List<CiaAerea> ciaAereas) {
		this.ciaAereas = ciaAereas;
	}
	
	public Papel getPapelSelecionado() {
		return papelSelecionado;
	}

	public void setPapelSelecionado(Papel papelSelecionado) {
		this.papelSelecionado = papelSelecionado;
	}
	
	
}

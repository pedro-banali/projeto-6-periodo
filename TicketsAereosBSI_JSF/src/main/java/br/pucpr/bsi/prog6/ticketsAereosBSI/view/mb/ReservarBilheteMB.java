package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBCFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dto.BilheteDTO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dto.ReservarBilheteFiltroDTO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class ReservarBilheteMB implements Serializable{
	
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	public static final String BILHETE_SELECIONADA = "bilheteSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ReservarBilheteMB.class);
	
	private ReservarBilheteFiltroDTO filtroPesquisa;
	private List<BilheteDTO> bilhetes;
	private BilheteDTO bilheteSelecionado;
	private List<Aeroporto> origens;
	private List<Aeroporto> destinos;
	private List<CiaAerea> ciaAereas;
	private TipoBilheteEnum tipoBilhete;
	
	
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	
	public ReservarBilheteMB() {
	}
	
	@PostConstruct
	private void init(){
		filtroPesquisa = (ReservarBilheteFiltroDTO) ViewUtil.getParameter(FILTRO_PESQUISA);
		log.debug("Valor do Filtro:" + filtroPesquisa);
		origens = AeroportoBC.getInstance().findAll();
		destinos = AeroportoBC.getInstance().findAll();
		ciaAereas = CiaAereaBC.getInstance().findAll();
		if(filtroPesquisa == null){
			filtroPesquisa = new ReservarBilheteFiltroDTO( "", 
					new CiaAerea(), 
					new Aeroporto(new Endereco()),
					new Aeroporto(new Endereco()),
					TipoBilheteEnum.ECONOMICA,
					new Passageiro(new Endereco()));
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
		bilhetes = BilheteBCFactory.getInstanceBC(filtroPesquisa.getTipoBilheteEnum()).findByFilter((IdentifierInterface)filtroPesquisa);
		if(bilhetes.isEmpty()){
			MessagesUtils.addInfo("informacao", "ER0133");
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
		if(bilheteSelecionado == null){
			throw new TicketsAereosBSIException("ER0123");
		}
	}
	
	private void setParameters(br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterRotaMB.Acoes acao){
		ViewUtil.setRequestParameter(BILHETE_SELECIONADA, bilheteSelecionado);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(acao);
	}
	
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	
	public ReservarBilheteFiltroDTO getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(ReservarBilheteFiltroDTO filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
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

	public List<BilheteDTO> getBilhetes() {
		return bilhetes;
	}

	public void setBilhetes(List<BilheteDTO> bilhetes) {
		this.bilhetes = bilhetes;
	}

	public List<Aeroporto> getOrigens() {
		return origens;
	}

	public void setOrigens(List<Aeroporto> origens) {
		this.origens = origens;
	}

	public BilheteDTO getBilheteSelecionado() {
		return bilheteSelecionado;
	}

	public void setBilheteSelecionado(BilheteDTO bilheteSelecionado) {
		this.bilheteSelecionado = bilheteSelecionado;
	}
	
	
	public TipoBilheteEnum[] getTipoBilheteEnums()
	{
		return TipoBilheteEnum.values();
	}

	public TipoBilheteEnum getTipoBilhete() {
		return tipoBilhete;
	}

	public void setTipoBilhete(TipoBilheteEnum tipoBilhete) {
		this.tipoBilhete = tipoBilhete;
	}
	
	
}
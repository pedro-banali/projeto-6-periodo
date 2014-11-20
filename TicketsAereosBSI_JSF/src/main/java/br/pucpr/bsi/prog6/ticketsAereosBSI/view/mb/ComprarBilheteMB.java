package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBCFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.EconomicaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.ExecutivaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PrimeiraBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dto.BilheteDTO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

@ManagedBean
@ViewScoped
public class ComprarBilheteMB implements Serializable{
	/////////////////////////////////////
	// Atributos
	/////////////////////////////////////
	private static final long serialVersionUID = 1L;
	public static final String BILHETE_SELECIONADO = "bilheteSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";
	//Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(ComprarBilheteMB.class);
	private List<BilheteDTO> bilhetes;
	private BilheteDTO bilheteSelecionado;
	private Passageiro passageiro;
	private List<Passageiro> passageiros;
	private TipoBilheteEnum tipoBilhete;
	
	/////////////////////////////////////
	// Construtores
	/////////////////////////////////////
	public ComprarBilheteMB() {
	}
	@PostConstruct
	private void init(){
		passageiros = PassageiroBC.getInstance().findAll();
		if(passageiro == null){
			passageiro = new Passageiro(new Endereco());
		} else {
			pesquisar();
		}
	}
	/////////////////////////////////////
	// Actions
	/////////////////////////////////////
	//Action de Pesquisar a partir do filtro
	public void pesquisar() {
		validarPesquisa();
		switch (tipoBilhete) {
			case ECONOMICA:
				bilhetes = EconomicaBC.getInstance().findBySituacao(passageiro, SituacaoBilheteEnum.RESERVADO);
				break;
			case EXECUTIVA:
				bilhetes = ExecutivaBC.getInstance().findBySituacao(passageiro, SituacaoBilheteEnum.RESERVADO);
				break;
			case PRIMEIRA:
				bilhetes = PrimeiraBC.getInstance().findBySituacao(passageiro, SituacaoBilheteEnum.RESERVADO);
				break;
		}
		if(bilhetes.isEmpty()){
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}
	
	public void comprar(){
		log.debug("Iniciando a operacao de visualizar");
		validate();
		@SuppressWarnings("rawtypes")
		BilheteBC bilheteBC = BilheteBCFactory.getInstanceBC(getTipoBilhete());
		bilheteBC.comprarBilhete(bilheteSelecionado.getIdBilhete());
		pesquisar();
		MessagesUtils.addInfo("sucesso", "IN0000");
	}
	/////////////////////////////////////
	// Metodos Utilitarios
	/////////////////////////////////////
	private void validate(){
		if(bilheteSelecionado == null){
			throw new TicketsAereosBSIException("ER0140");
		}
	}
	public void validarPesquisa(){
		if(passageiro == null || tipoBilhete == null){
			throw new TicketsAereosBSIException("ER0142");
		}
	}
	public List<TipoBilheteEnum> getTipoEnums(){
		List<TipoBilheteEnum> tipos =  new ArrayList<TipoBilheteEnum>();
		tipos.add(TipoBilheteEnum.ECONOMICA);
		tipos.add(TipoBilheteEnum.EXECUTIVA);
		tipos.add(TipoBilheteEnum.PRIMEIRA);
		return tipos;
	}
	/////////////////////////////////////
	// Getters and Setters
	/////////////////////////////////////
	public List<BilheteDTO> getBilhetes() {
		return bilhetes;
	}
	public void setBilhetes(List<BilheteDTO> bilhetes) {
		this.bilhetes = bilhetes;
	}
	public BilheteDTO getBilheteSelecionado() {
		return bilheteSelecionado;
	}
	public void setBilheteSelecionado(BilheteDTO bilheteSelecionado) {
		this.bilheteSelecionado = bilheteSelecionado;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public List<Passageiro> getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}
	public TipoBilheteEnum getTipoBilhete() {
		return tipoBilhete;
	}
	public void setTipoBilhete(TipoBilheteEnum tipoBilhete) {
		this.tipoBilhete = tipoBilhete;
	}
	
}
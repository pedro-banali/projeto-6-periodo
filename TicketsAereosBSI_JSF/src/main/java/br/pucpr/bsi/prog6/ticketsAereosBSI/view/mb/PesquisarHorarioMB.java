package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

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
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.ManterHorarioMB.Acoes;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils.ViewUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.MessagesUtils;

/**
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@ViewScoped
public class PesquisarHorarioMB implements Serializable {

	// ///////////////////////////////////
	// Atributos
	// ///////////////////////////////////

	private static final long serialVersionUID = 1L;

	public static final String HORARIO_SELECIONADO = "horarioSelecionado";
	public static final String FILTRO_PESQUISA = "filtroPesquisa";

	// Utilizado para logs via Log4J
	private static Logger log = Logger.getLogger(PesquisarHorarioMB.class);

	private Horario filtroPesquisa;

	private List<Horario> horarios;
	private List<CiaAerea> companhiasAereas;
	private List<Rota> rotas;
	private List<Aviao> avioes;
	private Rota rota;
	private Aviao aviao;
	private Aviao filtroAviao;
	private Horario horarioSelecionado;
	private CiaAerea ciaAerea;
	private CiaAerea filtroCiaAerea;

	// ///////////////////////////////////
	// Construtores
	// ///////////////////////////////////

	public PesquisarHorarioMB() {
	}

	@PostConstruct
	private void init() {
		filtroPesquisa = (Horario) ViewUtil.getParameter(FILTRO_PESQUISA);
		companhiasAereas = CiaAereaBC.getInstance().findAll();
		// setPapeis(PapelBC.getInstance().findAll());
		log.debug("Valor do Filtro:" + filtroPesquisa);

		rota = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));

		aviao = new Aviao(new CiaAerea());

		if (filtroPesquisa == null) {
			this.filtroPesquisa = new Horario(new Rota(new CiaAerea(),
					new Aeroporto(new Endereco()),
					new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		} else {
			pesquisar();
		}
	}

	// ///////////////////////////////////
	// Actions
	// ///////////////////////////////////

	// Action de Pesquisar a partir do filtro
	public void pesquisar() {
		
		if(rota != null && rota.getNome() != null)
			filtroPesquisa.setRota(rota);
		
		if(aviao != null && aviao.getCodigo() != null)
			filtroPesquisa.setAviao(aviao);
		
		if (filtroPesquisa.getRota() == null && ciaAerea != null) {
			filtroPesquisa.setRota(new Rota(ciaAerea, new Aeroporto(
					new Endereco()), new Aeroporto(new Endereco())));
		}
		if (filtroPesquisa.getAviao() == null && ciaAerea != null) {
			filtroPesquisa.setAviao(new Aviao(ciaAerea));
		}
		
		if(filtroPesquisa.getAviao().getCiaAerea().getNome()!= null)
		{
			ciaAerea = filtroPesquisa.getAviao().getCiaAerea();
			
			if(filtroPesquisa.getAviao().getCodigo()!= null)
			{
				avioes = AviaoBC.getInstance().findByFilter(filtroPesquisa.getAviao());
				aviao = filtroPesquisa.getAviao();
				
			}
			if(filtroPesquisa.getRota().getNome()!= null)
			{
				rotas = RotaBC.getInstance().findByFilter(filtroPesquisa.getRota());
				rota = filtroPesquisa.getRota();
			}
			
			
		}
		
		
		
		
		
		
		

		horarios = HorarioBC.getInstance().findByFilter(filtroPesquisa);
		if (horarios.isEmpty()) {
			MessagesUtils.addInfo("informacao", "IN0001");
		}
	}

	public String editar() {
		log.debug("Iniciando a operacao de editar");
		validate();
		setParameters(ManterHorarioMB.Acoes.EDITAR);
		return "manterHorario";
	}

	public String excluir() {
		log.debug("Iniciando a operacao de excluir");
		validate();
		setParameters(ManterHorarioMB.Acoes.EXCLUIR);
		return "manterHorario";
	}

	public String visualizar() {
		log.debug("Iniciando a operacao de visualizar");
		validate();
		setParameters(ManterHorarioMB.Acoes.VISUALIZAR);
		return "manterHorario";
	}

	// ///////////////////////////////////
	// Metodos Utilitarios
	// ///////////////////////////////////

	private void validate() {
		if (horarioSelecionado == null) {
			throw new TicketsAereosBSIException("ER0052");
		}
	}

	public void listarRotas() {
		if (rota == null)
			rota = new Rota(ciaAerea, new Aeroporto(new Endereco()),
					new Aeroporto(new Endereco()));

		filtroPesquisa.setRota(rota);
		filtroPesquisa.getRota().setCiaAerea(ciaAerea);

		rotas = RotaBC.getInstance().findByFilter(filtroPesquisa.getRota());
	}

	public void listarAvioes() {
		if (aviao == null)
			aviao = new Aviao(ciaAerea);

		filtroPesquisa.setAviao(aviao);
		filtroPesquisa.getAviao().setCiaAerea(ciaAerea);

		avioes = AviaoBC.getInstance().findByFilter(filtroPesquisa.getAviao());
	}

	private void setParameters(Acoes editar) {
		ViewUtil.setRequestParameter(HORARIO_SELECIONADO, horarioSelecionado);
		ViewUtil.setRequestParameter(FILTRO_PESQUISA, filtroPesquisa);
		ViewUtil.setRequestParameter(editar);
	}

	public Horario getFiltroPesquisa() {
		return filtroPesquisa;
	}

	public void setFiltroPesquisa(Horario filtroPesquisa) {
		this.filtroPesquisa = filtroPesquisa;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public List<CiaAerea> getCompanhiasAereas() {
		return companhiasAereas;
	}

	public void setCompanhiasAereas(List<CiaAerea> companhiasAereas) {
		this.companhiasAereas = companhiasAereas;
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

	public Horario getHorarioSelecionado() {
		return horarioSelecionado;
	}

	public void setHorarioSelecionado(Horario horarioSelecionado) {
		this.horarioSelecionado = horarioSelecionado;
	}

	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}

	public void setCiaAerea(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	// ///////////////////////////////////
	// Getters and Setters
	// ///////////////////////////////////

}
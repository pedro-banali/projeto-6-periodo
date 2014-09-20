package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;


public enum RotaEnum {
	
	ROTA_BSB_CNF_AZUL("BSB-CNF-Azul", "Brasilia para Belo Horizonte via Azul", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.AZUL),
	ROTA_BSB_CWB_AZUL("BSB-CWB-Azul", "Brasilia para Curitiba via Azul", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.AZUL),
	ROTA_BSB_GRU_AZUL("BSB-GRU-Azul", "Brasilia para Guarulhos via Azul", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.AZUL),
	ROTA_BSB_POA_AZUL("BSB-POA-Azul", "Brasilia para Porto Alegre via Azul", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.AZUL),
	ROTA_BSB_SDU_AZUL("BSB-SDU-Azul", "Brasilia para Rio de Janeiro via Azul", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.AZUL),
	
	ROTA_CNF_BSB_AZUL("CNF-BSB-Azul", "Belo Horizonte para Brasilia via Azul", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.AZUL),
	ROTA_CNF_CWB_AZUL("CNF-CWB-Azul", "Belo Horizonte para Curitiba via Azul", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.AZUL),
	ROTA_CNF_GRU_AZUL("CNF-GRU-Azul", "Belo Horizonte para Guarulhos via Azul", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.AZUL),
	ROTA_CNF_POA_AZUL("CNF-POA-Azul", "Belo Horizonte para Porto Alegre via Azul", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.AZUL),
	ROTA_CNF_SDU_AZUL("CNF-SDU-Azul", "Belo Horizonte para Rio de Janeiro via Azul", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.AZUL),
	
	ROTA_CWB_BSB_AZUL("CWB-BSB-Azul", "Curitiba para Brasilia via Azul", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.AZUL),
	ROTA_CWB_CNF_AZUL("CWB-CNF-Azul", "Curitiba para Belo Horizonte via Azul", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.AZUL),
	ROTA_CWB_GRU_AZUL("CWB-GRU-Azul", "Curitiba para Guarulhos via Azul", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.AZUL),
	ROTA_CWB_POA_AZUL("CWB-POA-Azul", "Curitiba para Porto Alegre via Azul", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.AZUL),
	ROTA_CWB_SDU_AZUL("CWB-SDU-Azul", "Curitiba para Rio de Janeiro via Azul", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.AZUL),
	
	ROTA_GRU_BSB_AZUL("GRU-BSB-Azul", "Guarulhos para Brasilia via Azul", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.AZUL),
	ROTA_GRU_CNF_AZUL("GRU-CNF-Azul", "Guarulhos para Belo Horizonte via Azul", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.AZUL),
	ROTA_GRU_CWB_AZUL("GRU-CWB-Azul", "Guarulhos para Curitiba via Azul", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.AZUL),
	ROTA_GRU_POA_AZUL("GRU-POA-Azul", "Guarulhos para Porto Alegre via Azul", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.AZUL),
	ROTA_GRU_SDU_AZUL("GRU-SDU-Azul", "Guarulhos para Rio de Janeiro via Azul", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.AZUL),
	
	ROTA_POA_BSB_AZUL("POA-BSB-Azul", "Porto Alegre para Brasilia via Azul", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.AZUL),
	ROTA_POA_CNF_AZUL("POA-CNF-Azul", "Porto Alegre para Belo Horizonte via Azul", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.AZUL),
	ROTA_POA_CWB_AZUL("POA-CWB-Azul", "Porto Alegre para Curitiba via Azul", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.AZUL),
	ROTA_POA_GRU_AZUL("POA-GRU-Azul", "Porto Alegre para Guarulhos via Azul", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.AZUL),
	ROTA_POA_SDU_AZUL("POA-SDU-Azul", "Porto Alegre para Rio de Janeiro via Azul", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.AZUL),
	
	ROTA_SDU_BSB_AZUL("SDU-BSB-Azul", "Rio de Janeiro para Brasilia via Azul", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.AZUL),	
	ROTA_SDU_CNF_AZUL("SDU-CNF-Azul", "Rio de Janeiro para Belo Horizonte via Azul", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.AZUL),
	ROTA_SDU_CWB_AZUL("SDU-CWB-Azul", "Rio de Janeiro para Curitiba via Azul", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.AZUL),
	ROTA_SDU_GRU_AZUL("SDU-GRU-Azul", "Rio de Janeiro para Guarulhos via Azul", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.AZUL),
	ROTA_SDU_POA_AZUL("SDU-POA-Azul", "Rio de Janeiro para Porto Alegre via Azul", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.AZUL),
	
	
	ROTA_BSB_CNF_GOL("BSB-CNF-Gol", "Brasilia para Belo Horizonte via Gol", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.GOL),
	ROTA_BSB_CWB_GOL("BSB-CWB-Gol", "Brasilia para Curitiba via Gol", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.GOL),
	ROTA_BSB_GRU_GOL("BSB-GRU-Gol", "Brasilia para Guarulhos via Gol", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.GOL),
	ROTA_BSB_POA_GOL("BSB-POA-Gol", "Brasilia para Porto Alegre via Gol", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.GOL),
	ROTA_BSB_SDU_GOL("BSB-SDU-Gol", "Brasilia para Rio de Janeiro via Gol", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.GOL),
	
	ROTA_CNF_BSB_GOL("CNF-BSB-Gol", "Belo Horizonte para Brasilia via Gol", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.GOL),
	ROTA_CNF_CWB_GOL("CNF-CWB-Gol", "Belo Horizonte para Curitiba via Gol", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.GOL),
	ROTA_CNF_GRU_GOL("CNF-GRU-Gol", "Belo Horizonte para Guarulhos via Gol", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.GOL),
	ROTA_CNF_POA_GOL("CNF-POA-Gol", "Belo Horizonte para Porto Alegre via Gol", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.GOL),
	ROTA_CNF_SDU_GOL("CNF-SDU-Gol", "Belo Horizonte para Rio de Janeiro via Gol", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.GOL),
	
	ROTA_CWB_BSB_GOL("CWB-BSB-Gol", "Curitiba para Brasilia via Gol", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.GOL),
	ROTA_CWB_CNF_GOL("CWB-CNF-Gol", "Curitiba para Belo Horizonte via Gol", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.GOL),
	ROTA_CWB_GRU_GOL("CWB-GRU-Gol", "Curitiba para Guarulhos via Gol", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.GOL),
	ROTA_CWB_POA_GOL("CWB-POA-Gol", "Curitiba para Porto Alegre via Gol", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.GOL),
	ROTA_CWB_SDU_GOL("CWB-SDU-Gol", "Curitiba para Rio de Janeiro via Gol", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.GOL),
	
	ROTA_GRU_BSB_GOL("GRU-BSB-Gol", "Guarulhos para Brasilia via Gol", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.GOL),
	ROTA_GRU_CNF_GOL("GRU-CNF-Gol", "Guarulhos para Belo Horizonte via Gol", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.GOL),
	ROTA_GRU_CWB_GOL("GRU-CWB-Gol", "Guarulhos para Curitiba via Gol", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.GOL),
	ROTA_GRU_POA_GOL("GRU-POA-Gol", "Guarulhos para Porto Alegre via Gol", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.GOL),
	ROTA_GRU_SDU_GOL("GRU-SDU-Gol", "Guarulhos para Rio de Janeiro via Gol", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.GOL),
	
	ROTA_POA_BSB_GOL("POA-BSB-Gol", "Porto Alegre para Brasilia via Gol", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.GOL),
	ROTA_POA_CNF_GOL("POA-CNF-Gol", "Porto Alegre para Belo Horizonte via Gol", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.GOL),
	ROTA_POA_CWB_GOL("POA-CWB-Gol", "Porto Alegre para Curitiba via Gol", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.GOL),
	ROTA_POA_GRU_GOL("POA-GRU-Gol", "Porto Alegre para Guarulhos via Gol", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.GOL),
	ROTA_POA_SDU_GOL("POA-SDU-Gol", "Porto Alegre para Rio de Janeiro via Gol", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.GOL),
	
	ROTA_SDU_BSB_GOL("SDU-BSB-Gol", "Rio de Janeiro para Brasilia via Gol", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.GOL),		
	ROTA_SDU_CNF_GOL("SDU-CNF-Gol", "Rio de Janeiro para Belo Horizonte via Gol", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.GOL),
	ROTA_SDU_CWB_GOL("SDU-CWB-Gol", "Rio de Janeiro para Curitiba via Gol", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.GOL),
	ROTA_SDU_GRU_GOL("SDU-GRU-Gol", "Rio de Janeiro para Guarulhos via Gol", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.GOL),
	ROTA_SDU_POA_GOL("SDU-POA-Gol", "Rio de Janeiro para Porto Alegre via Gol", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.GOL),
	
	
	ROTA_BSB_CNF_TAM("BSB-CNF-Tam", "Brasilia para Belo Horizonte via Tam", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.TAM),
	ROTA_BSB_CWB_TAM("BSB-CWB-Tam", "Brasilia para Curitiba via Tam", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.TAM),
	ROTA_BSB_GRU_TAM("BSB-GRU-Tam", "Brasilia para Guarulhos via Tam", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.TAM),
	ROTA_BSB_POA_TAM("BSB-POA-Tam", "Brasilia para Porto Alegre via Tam", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.TAM),
	ROTA_BSB_SDU_TAM("BSB-SDU-Tam", "Brasilia para Rio de Janeiro via Tam", AeroportoEnum.AERO_BRASILIA, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.TAM),
	
	ROTA_CNF_BSB_TAM("CNF-BSB-Tam", "Belo Horizonte para Brasilia via Tam", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.TAM),
	ROTA_CNF_CWB_TAM("CNF-CWB-Tam", "Belo Horizonte para Curitiba via Tam", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.TAM),
	ROTA_CNF_GRU_TAM("CNF-GRU-Tam", "Belo Horizonte para Guarulhos via Tam", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.TAM),
	ROTA_CNF_POA_TAM("CNF-POA-Tam", "Belo Horizonte para Porto Alegre via Tam", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.TAM),
	ROTA_CNF_SDU_TAM("CNF-SDU-Tam", "Belo Horizonte para Rio de Janeiro via Tam", AeroportoEnum.AERO_CONFINS, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.TAM),
	
	ROTA_CWB_BSB_TAM("CWB-BSB-Tam", "Curitiba para Brasilia via Tam", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.TAM),
	ROTA_CWB_CNF_TAM("CWB-CNF-Tam", "Curitiba para Belo Horizonte via Tam", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.TAM),
	ROTA_CWB_GRU_TAM("CWB-GRU-Tam", "Curitiba para Guarulhos via Tam", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.TAM),
	ROTA_CWB_POA_TAM("CWB-POA-Tam", "Curitiba para Porto Alegre via Tam", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.TAM),
	ROTA_CWB_SDU_TAM("CWB-SDU-Tam", "Curitiba para Rio de Janeiro via Tam", AeroportoEnum.AERO_CURITIBA, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.TAM),
	
	ROTA_GRU_BSB_TAM("GRU-BSB-Tam", "Guarulhos para Brasilia via Tam", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.TAM),
	ROTA_GRU_CNF_TAM("GRU-CNF-Tam", "Guarulhos para Belo Horizonte via Tam", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.TAM),
	ROTA_GRU_CWB_TAM("GRU-CWB-Tam", "Guarulhos para Curitiba via Tam", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.TAM),
	ROTA_GRU_POA_TAM("GRU-POA-Tam", "Guarulhos para Porto Alegre via Tam", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.TAM),
	ROTA_GRU_SDU_TAM("GRU-SDU-Tam", "Guarulhos para Rio de Janeiro via Tam", AeroportoEnum.AERO_GUARULHOS, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.TAM),
	
	ROTA_POA_BSB_TAM("POA-BSB-Tam", "Porto Alegre para Brasilia via Tam", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.TAM),
	ROTA_POA_CNF_TAM("POA-CNF-Tam", "Porto Alegre para Belo Horizonte via Tam", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.TAM),
	ROTA_POA_CWB_TAM("POA-CWB-Tam", "Porto Alegre para Curitiba via Tam", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.TAM),
	ROTA_POA_GRU_TAM("POA-GRU-Tam", "Porto Alegre para Guarulhos via Tam", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.TAM),
	ROTA_POA_SDU_TAM("POA-SDU-Tam", "Porto Alegre para Rio de Janeiro via Tam", AeroportoEnum.AERO_PORTO_ALEGRE, AeroportoEnum.AERO_SANTOS_DUMONT, CiaAereaEnum.TAM),
	
	ROTA_SDU_BSB_TAM("SDU-BSB-Tam", "Rio de Janeiro para Brasilia via Tam", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_BRASILIA, CiaAereaEnum.TAM),
	ROTA_SDU_CNF_TAM("SDU-CNF-Tam", "Rio de Janeiro para Belo Horizonte via Tam", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_CONFINS, CiaAereaEnum.TAM),
	ROTA_SDU_CWB_TAM("SDU-CWB-Tam", "Rio de Janeiro para Curitiba via Tam", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_CURITIBA, CiaAereaEnum.TAM),
	ROTA_SDU_GRU_TAM("SDU-GRU-Tam", "Rio de Janeiro para Guarulhos via Tam", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_GUARULHOS, CiaAereaEnum.TAM),
	ROTA_SDU_POA_TAM("SDU-POA-Tam", "Rio de Janeiro para Porto Alegre via Tam", AeroportoEnum.AERO_SANTOS_DUMONT, AeroportoEnum.AERO_PORTO_ALEGRE, CiaAereaEnum.TAM);
	
	private String nome, descricao;
	private AeroportoEnum origem, destino;
	private CiaAereaEnum ciaAerea;
	
	private RotaEnum(String nome, String descricao, AeroportoEnum origem, AeroportoEnum destino, CiaAereaEnum ciaAereaEnum) {
		this.nome = nome;
		this.descricao = descricao;
		this.origem = origem;
		this.destino = destino;
		this.ciaAerea = ciaAereaEnum;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public AeroportoEnum getOrigem() {
		return origem;
	}
	
	public AeroportoEnum getDestino() {
		return destino;
	}
	
	public CiaAereaEnum getCiaAerea() {
		return ciaAerea;
	}
}

package br.pucpr.bsi.prog6.ticketsAereosBSI.enums;

public enum TipoBilheteEnum {
		UM(1, "Econômica"), 
		DOIS(2,"Executiva"),
		TRES(3, "Primeira");
		
		private int id;
		private String nome;
		
		TipoBilheteEnum(int id, String nome)
		{
			this.id = id;
			this.nome = nome;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
}

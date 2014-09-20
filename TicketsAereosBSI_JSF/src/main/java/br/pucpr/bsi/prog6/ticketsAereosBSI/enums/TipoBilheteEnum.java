package br.pucpr.bsi.prog6.ticketsAereosBSI.enums;

public enum TipoBilheteEnum {
		ECONOMICA(1, "Economica", "EC"), 
		EXECUTIVA(2, "Executiva", "EX"), 
		PRIMEIRA(3, "Primeira", "PR");

		
		private int id;
		private String nome;
		private String acronimo;
		
		TipoBilheteEnum(int id, String nome, String acronimo)
		{
			this.id = id;
			this.nome = nome;
			this.acronimo =  acronimo;
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

		public String getAcronimo() {
			return acronimo;
		}

		public void setAcronimo(String acronimo) {
			this.acronimo = acronimo;
		}
		
		
		
		
}

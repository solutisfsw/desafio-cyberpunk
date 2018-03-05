package br.com.solutis.cyberpunk.model;


public enum Adicional {
	
	BRACO_MECANICO("Braço Mecânico"),
	ESQUELETO_REFORCADO("Esqueleto Reforçado"),
	SENTIDOS_AGUCADOS("Sentidos Aguçados"),
	PELE_ADAPTATIVA("Pele Adaptativa"),
	RAIO_LASER("Raio Laser");	
	
	private String nome;
	
	Adicional(String nome) {
	this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}

package org.juanfsrv.cyberpunk.enums;

public enum AdicionaisEnum {
	BRAÇO_MECÂNICO ("Braço Mecânico"),
	ESQUELETO_REFORÇADO ("Esqueleto Reforçado"),
	SENTIDOS_AGUÇADOS ("Sentidos Aguçados"),
	PELE_ADAPTATIVA ("Pele Adaptativa"),
	RAIO_LASER ("Raio Laser");
	
	private final String descricao;
	
	AdicionaisEnum(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}

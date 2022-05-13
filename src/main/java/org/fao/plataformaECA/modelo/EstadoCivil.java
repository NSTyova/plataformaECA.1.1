package org.fao.plataformaECA.modelo;

public enum EstadoCivil {
 SOLTEIRO("Solteiro(a)"),
 CASADO("Casado(a)"),
 VIÚVO("Viuvo"),
 DIVORCIADO("Divorciado");
 
 private final String descricao;
 
 private EstadoCivil(String descricao) {
	this.descricao=descricao;
}
 public String getDescricao() {
	return descricao;
}
}

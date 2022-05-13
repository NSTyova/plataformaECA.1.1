package org.fao.plataformaECA.resource.detalhes;

import org.fao.plataformaECA.modelo.Titulo;

import lombok.Getter;

@Getter
public class DetalhesDoTituloDTO {

	private Long id;
	private String descricao;
	
	
	public DetalhesDoTituloDTO (Titulo titulo) {
		this.id=titulo.getId();
		this.descricao=titulo.getDescricao();
	}
}

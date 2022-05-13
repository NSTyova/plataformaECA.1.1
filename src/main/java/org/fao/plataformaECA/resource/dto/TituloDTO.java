package org.fao.plataformaECA.resource.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.fao.plataformaECA.modelo.Titulo;

import lombok.Getter;

@Getter
public class TituloDTO {

	private Long id;
	private String descricao;
	
	public TituloDTO (Titulo titulo) {
		this.id=titulo.getId();
		this.descricao=titulo.getDescricao();
		}
	public TituloDTO() {
	}
	
	public static List<TituloDTO> convert(List<Titulo> titulos) {
		
		return titulos.stream().map(TituloDTO::new).collect(Collectors.toList());
	}
}

package org.fao.plataformaECA.resource.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.fao.plataformaECA.modelo.Agregacao;
import org.fao.plataformaECA.modelo.Membro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AgregacaoDTO {

	private Long id;
	private int qtdFilhos;
	private int filhosMenorCinco;
	private int filhosMaiorCinco;
	private String codigoFamilia;
	private Membro membro;
	public AgregacaoDTO (Agregacao agregacao) {
		this.id=agregacao.getId();
		this.qtdFilhos=agregacao.getQtdFilhos();
		this.filhosMaiorCinco=agregacao.getFilhosMaiorCinco();
		this.filhosMenorCinco=agregacao.getFilhosMenorCinco();
		this.codigoFamilia=agregacao.getCodigoFamilia();
		this.membro=agregacao.getMembro();
	}
	
	public static List<AgregacaoDTO> convert(List<Agregacao> agregacaos) {
		
		return agregacaos.stream().map(AgregacaoDTO::new).collect(Collectors.toList());
	}
	
}

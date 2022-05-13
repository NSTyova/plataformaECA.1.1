package org.fao.plataformaECA.resource.detalhes;

import org.fao.plataformaECA.modelo.Agregacao;
import org.fao.plataformaECA.modelo.Membro;

import lombok.Getter;

@Getter
public class DetalhesDaAgregacaoDTO {

	private Long id;
	private int qtdFilhos;
	private int filhosMenorCinco;
	private int filhosMaiorCinco;
	private String codigoFamilia;
	private Membro membro;
	
	public DetalhesDaAgregacaoDTO (Agregacao agregacao) {
		this.id=agregacao.getId();
		this.qtdFilhos=agregacao.getQtdFilhos();
		this.filhosMaiorCinco=agregacao.getFilhosMaiorCinco();
		this.filhosMenorCinco=agregacao.getFilhosMenorCinco();
		this.codigoFamilia=agregacao.getCodigoFamilia();
		this.membro=agregacao.getMembro();
	}
}

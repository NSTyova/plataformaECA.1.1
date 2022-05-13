package org.fao.plataformaECA.resource.form;

import org.fao.plataformaECA.modelo.Agregacao;
import org.fao.plataformaECA.modelo.Membro;
import org.fao.plataformaECA.repository.MembroRepository;

import lombok.Getter;

@Getter
public class AgregacaoForm {
	private Long id;
	private int qtdFilhos;
	private int filhosMenorCinco;
	private int filhosMaiorCinco;
	private String codigoFamilia;
	private Long membro;
	
	public Agregacao convert(MembroRepository membroRepository) {
		Membro m = membroRepository.getById(membro);
		return new Agregacao(qtdFilhos, filhosMenorCinco, filhosMaiorCinco, codigoFamilia,  m);
	}
}

package org.fao.plataformaECA.resource.form.update;

import org.fao.plataformaECA.modelo.Agregacao;
import org.fao.plataformaECA.modelo.Membro;
import org.fao.plataformaECA.repository.AgregacaoRepository;
import org.fao.plataformaECA.repository.MembroRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgregacaoAtualizar {

	private Long id;
	private int qtdFilhos;
	private int filhosMenorCinco;
	private int filhosMaiorCinco;
	private String codigoFamilia;
	private Long membro;
	
	public Agregacao atualizar(Long id, AgregacaoRepository repository, MembroRepository membroRepository) {
		Agregacao agregacao= repository.getById(id);
		Membro membro=membroRepository.getById(id);
		agregacao.setFilhosMaiorCinco(this.filhosMaiorCinco);
		agregacao.setFilhosMenorCinco(this.filhosMenorCinco);
		agregacao.setQtdFilhos(this.qtdFilhos);
		agregacao.setCodigoFamilia(this.codigoFamilia);
		agregacao.setMembro(membro);
		return agregacao;
	}
}

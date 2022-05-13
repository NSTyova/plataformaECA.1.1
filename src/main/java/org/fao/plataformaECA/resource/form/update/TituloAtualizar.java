package org.fao.plataformaECA.resource.form.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.fao.plataformaECA.modelo.Titulo;
import org.fao.plataformaECA.repository.TituloRepository;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TituloAtualizar {

	@NotBlank
	@Size(min = 3, max = 30)
	private String descricao;
	public Titulo atualizar(Long id, TituloRepository repository) {
		Titulo titulo= repository.getById(id);
		titulo.setDescricao(this.descricao);
		return titulo;
	}
}

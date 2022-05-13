package org.fao.plataformaECA.resource.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.fao.plataformaECA.modelo.Titulo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TituloForm {

	@NotBlank
	@Size(min = 3, max = 30)
	private String descricao;
	
	public Titulo convert() {
		return new Titulo(descricao);
	}
}

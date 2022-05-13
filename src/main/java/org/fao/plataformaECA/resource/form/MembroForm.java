package org.fao.plataformaECA.resource.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.fao.plataformaECA.modelo.Membro;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembroForm {

	@NotBlank
	@Size
	private String nome;
	@NotBlank
	private String telefone;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	
	private boolean temBilhete;
	
	private String dificiente;
	
	private String genero;
	
	private String estadoCivil;
	private boolean contaBancaria;
	
	public Membro convert() {
		return new Membro( nome,  telefone,  dataNascimento,  temBilhete,  dificiente,
				 genero,  estadoCivil,  contaBancaria);
	}
}

package org.fao.plataformaECA.resource.form.update;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.fao.plataformaECA.modelo.Membro;
import org.fao.plataformaECA.repository.MembroRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembroAtualizar {


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
	
	public Membro atualizar(Long id, MembroRepository repository) {
		Membro membro= repository.getById(id);
		membro.setNome(this.nome);
		membro.setTelefone(this.telefone);
		membro.setDataNascimento(this.dataNascimento);
		membro.setTemBilhete(this.temBilhete);
		return membro;
	}
	
	
}

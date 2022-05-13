package org.fao.plataformaECA.resource.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.fao.plataformaECA.modelo.Membro;

import lombok.Getter;

@Getter
public class MembroDTO {

	private Long id;
	private String nome;
	private String telefone;
	private LocalDate dataNascimento;
	private boolean temBilhete;
	private String dificiente;
	private String genero;
	private String estadoCivil;
	private boolean contaBancaria;
	
	public MembroDTO (Membro membro) {
		this.id=membro.getId();
		this.nome=membro.getNome();
		this.telefone=membro.getTelefone();
		this.dataNascimento=membro.getDataNascimento();
		this.temBilhete=membro.isTemBilhete();
		this.dificiente=membro.getDificiente();
		this.estadoCivil=membro.getEstadoCivil();
		this.contaBancaria=membro.isContaBancaria();
		this.genero=membro.getGenero();
	}
	public MembroDTO() {
	}
	
	public static List<MembroDTO> convert(List<Membro> categorias) {
		
		return categorias.stream().map(MembroDTO::new).collect(Collectors.toList());
	}
	
	public boolean isContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(boolean contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	
	public boolean isTemBilhete() {
		return contaBancaria;
	}

	public void setTemBilhete(boolean temBilhete) {
		this.temBilhete = temBilhete;
	}
}

package org.fao.plataformaECA.resource.detalhes;

import java.time.LocalDate;

import org.fao.plataformaECA.modelo.Membro;

import lombok.Getter;

@Getter
public class DetalhesDoMembroDTO {
	private Long id;
	private String nome;
	private String telefone;
	private LocalDate dataNascimento;
	private boolean temBilhete;
	private String dificiente;
	private boolean contaBancaria;
	
	
	public DetalhesDoMembroDTO (Membro membro) {
		this.id=membro.getId();
		this.nome=membro.getNome();
		this.telefone=membro.getTelefone();
		this.dataNascimento=membro.getDataNascimento();
		this.temBilhete=membro.isTemBilhete();
		this.dificiente=membro.getDificiente();
		this.contaBancaria=membro.isContaBancaria();
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

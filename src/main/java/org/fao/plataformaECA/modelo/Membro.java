package org.fao.plataformaECA.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Membro")
@Setter
@Getter
public class Membro {

	@Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	@Column(name = "data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;
	@Column(name = "tem_bilhete")
	private boolean temBilhete;
	@Column(name = "dificiente")
	private String dificiente;
	private String genero;
	@Column(name = "estado_civil")
	private String estadoCivil;
	@Column(name = "conta_bancaria")
	private boolean contaBancaria;
	public Membro(String nome, String telefone, LocalDate dataNascimento, boolean temBilhete, String dificiente,
			String genero, String estadoCivil, boolean contaBancaria) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.temBilhete = temBilhete;
		this.dificiente = dificiente;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.contaBancaria = contaBancaria;
	}
	public Membro() {
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
	
	/*
	 * passar aqui o OneToMany ou OneToOne
	 */
}

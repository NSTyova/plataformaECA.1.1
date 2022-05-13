package org.fao.plataformaECA.resource.detalhes;

import java.time.LocalDate;

import org.fao.plataformaECA.modelo.Projecto;

import lombok.Getter;

@Getter
public class DetalhesDoProjectoDTO {

	private Long id;
	 private String nome;
	    private String abreviacao;
	    private boolean estado;
	    private Double orcamento;
	    private LocalDate data_criacao;
	    private String codigo;
	
	
	public DetalhesDoProjectoDTO (Projecto projecto) {
		this.id=projecto.getId();
		this.nome=projecto.getNome();
		this.abreviacao=projecto.getAbreviacao();
		this.orcamento=projecto.getOrcamento();
		this.data_criacao=projecto.getDataCriacao();
		this.codigo=projecto.getCodigo();
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}

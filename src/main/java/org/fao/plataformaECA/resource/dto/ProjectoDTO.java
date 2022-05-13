package org.fao.plataformaECA.resource.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.fao.plataformaECA.modelo.Projecto;

import lombok.Getter;

@Getter
public class ProjectoDTO {

    private Long id;
    private String nome;
    private String abreviacao;
    private boolean estado;
    private Double orcamento;
    private LocalDate data_criacao;
    private String codigo;
	
	public ProjectoDTO (Projecto projecto) {
		this.id=projecto.getId();
		this.nome=projecto.getNome();
		this.abreviacao=projecto.getAbreviacao();
		this.orcamento=projecto.getOrcamento();
		this.data_criacao=projecto.getDataCriacao();
		this.codigo=projecto.getCodigo();
	}
	
	public ProjectoDTO() {
	}
	
public static List<ProjectoDTO> convert(List<Projecto> projectos) {
		
		return projectos.stream().map(ProjectoDTO::new).collect(Collectors.toList());
	}

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}
}

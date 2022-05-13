package org.fao.plataformaECA.resource.form;

import java.time.LocalDate;

import org.fao.plataformaECA.modelo.Projecto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectoForm {

	private String nome;
    private String abreviacao;
    private boolean estado;
    private Double orcamento;
    private LocalDate dataCriacao=LocalDate.now();
    private String codigo;
	
	public Projecto convert() {
		return new Projecto(nome, abreviacao, estado, orcamento,  dataCriacao,
			codigo);
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}

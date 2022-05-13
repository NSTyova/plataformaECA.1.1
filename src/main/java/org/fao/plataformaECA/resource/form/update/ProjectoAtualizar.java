package org.fao.plataformaECA.resource.form.update;

import java.time.LocalDate;

import org.fao.plataformaECA.modelo.Projecto;
import org.fao.plataformaECA.repository.ProjectoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectoAtualizar {

	
	private String nome;
    private String abreviacao;
    private boolean estado;
    private Double orcamento;
    private LocalDate dataCriacao=LocalDate.now();
    private Integer codigo;
	public Projecto atualizar(Long id, ProjectoRepository repository) {
		Projecto projecto= repository.getById(id);
		projecto.setNome(this.nome);
		projecto.setAbreviacao(this.abreviacao);
		return projecto;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}

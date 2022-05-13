package org.fao.plataformaECA.modelo;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PROJECTO")
@Getter
@Setter
public class Projecto {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    private String abreviacao;

    private boolean estado;

    private Double orcamento;
    @Column(name = "data_registro")
    private LocalDate dataCriacao;


    private String codigo;

    public Projecto() {
    }

	public Projecto(String nome, String abreviacao, boolean estado, Double orcamento, LocalDate dataCriacao,
			String codigo) {
		this.nome = nome;
		this.abreviacao = abreviacao;
		this.estado = estado;
		this.orcamento = orcamento;
		this.dataCriacao = dataCriacao;
		this.codigo = codigo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
   
 

}
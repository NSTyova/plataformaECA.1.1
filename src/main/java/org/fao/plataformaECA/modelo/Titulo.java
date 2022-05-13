package org.fao.plataformaECA.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_TITULO")
@Getter
@Setter
public class Titulo {

	@Id
	@Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	public Titulo(String descricao) {
		this.descricao = descricao;
	}
	public Titulo() {
		
	}
}

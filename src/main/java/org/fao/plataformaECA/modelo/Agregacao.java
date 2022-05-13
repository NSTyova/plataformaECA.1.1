package org.fao.plataformaECA.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_AGREGACAO")
@Getter
@Setter
@NoArgsConstructor
public class Agregacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Long id;
	@Column(name = "quantidades_filhos")
	private int qtdFilhos;
	@Column(name = "filhos_menor_cinco_anos")
	private int filhosMenorCinco;
	@Column(name = "filhos_maior_cinco_anos")
	private int filhosMaiorCinco;
	@Column(name = "codigo_familia")
	private String codigoFamilia;
	@ManyToOne
	@JoinColumn(name = "membro")
	private Membro membro;
	public Agregacao(int qtdFilhos, int filhosMenorCinco, int filhosMaiorCinco, String codigoFamilia, Membro membro) {
		super();
		this.qtdFilhos = qtdFilhos;
		this.filhosMenorCinco = filhosMenorCinco;
		this.filhosMaiorCinco = filhosMaiorCinco;
		this.codigoFamilia = codigoFamilia;
		this.membro = membro;
	}
	
	
}

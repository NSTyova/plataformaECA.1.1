package org.fao.plataformaECA.repository;

import org.fao.plataformaECA.modelo.Agregacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgregacaoRepository extends JpaRepository<Agregacao, Long>{

}

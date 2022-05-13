package org.fao.plataformaECA.repository;

import org.fao.plataformaECA.modelo.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long>{

}

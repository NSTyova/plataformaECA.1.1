package org.fao.plataformaECA.repository;

import org.fao.plataformaECA.modelo.Membro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MembroRepository extends JpaRepository<Membro, Long>{

	Page<Membro> findByNome(String nome, Pageable paginacao);

	

}

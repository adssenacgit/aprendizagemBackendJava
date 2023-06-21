package br.com.aprendizagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.Encontro;

@Repository
public interface EncontroRepository extends JpaRepository<Encontro, String>{

//	Page<Usuario> findAllByOrderByNomeAsc(Pageable pageable);
//	
//
//	Page<Usuario> findAllByOrderByNomeDesc(Pageable pageable);
	
}

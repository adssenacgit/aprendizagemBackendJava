package br.com.aprendizagem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, String>{

//	Page<Noticia> findAllByOrderByNomeAsc(Pageable pageable);
//	
//
//	Page<Noticia> findAllByOrderByNomeDesc(Pageable pageable);

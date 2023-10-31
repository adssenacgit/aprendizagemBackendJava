package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.GrupoChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoChapterRespository extends JpaRepository<GrupoChapter, Integer> {
    Optional<GrupoChapter> findByGrupoId(Long grupoId);
}

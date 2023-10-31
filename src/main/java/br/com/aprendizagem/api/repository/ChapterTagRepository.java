package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.ChapterTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterTagRepository extends JpaRepository<ChapterTag, Long> {
}

package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
}

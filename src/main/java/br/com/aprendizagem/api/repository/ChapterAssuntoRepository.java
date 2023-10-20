package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChapterAssuntoRepository extends JpaRepository<ChapterAssunto, Integer> {

    @Query("SELECT ca FROM ChapterAssunto ca WHERE ca.status = 1")
    List<ChapterAssunto> getAllChapterAssunto();
}

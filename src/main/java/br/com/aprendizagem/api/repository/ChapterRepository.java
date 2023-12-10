package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

    @Query("SELECT c FROM Chapter c WHERE c.status = 1")
    List<Chapter> getActiveChapters();

    @Query("SELECT c FROM Chapter c WHERE c.status = 2")
    Chapter getNoticiasChapter();
}
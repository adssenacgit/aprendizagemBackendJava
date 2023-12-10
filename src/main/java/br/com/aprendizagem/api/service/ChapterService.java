package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.repository.ChapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ChapterService {
    private final ChapterRepository chapterRepository;

    @Transactional
    public List<Chapter> getActiveChapters() {
        return chapterRepository.getActiveChapters();
    }

    @Transactional
    public Chapter getNoticiasChapter() {
        return chapterRepository.getNoticiasChapter();
    }

    @Transactional
    public Chapter postChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }
}
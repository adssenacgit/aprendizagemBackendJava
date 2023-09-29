package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.repository.ChapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChapterService {
    private final ChapterRepository chapterRepository;

    @Transactional
    public List<Chapter> getAllChapters() {
        List<Chapter> chapters = chapterRepository.findAll();
        return getActiveChapters(chapters);
    }

    public List<Chapter> getActiveChapters(List<Chapter> chapters){
        return chapters.stream().filter(c -> c.getStatus() == 1).collect(Collectors.toList());
    }
}

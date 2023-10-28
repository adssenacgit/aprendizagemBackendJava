package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.entity.ChapterAssuntoTag;
import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.repository.ChapterAssuntoRepository;
import br.com.aprendizagem.api.repository.ChapterAssuntoTagRepository;
import br.com.aprendizagem.api.repository.ChapterTagRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ChapterAssuntoService {

    private final ChapterAssuntoRepository chapterAssuntoRepository;
    private final ChapterTagRepository chapterTagRepository;
    private final ChapterAssuntoTagRepository chapterAssuntoTagRepository;

    @Transactional
    public ResponseEntity<List<ChapterAssunto>> getAllChapterAssunto() {
        List<ChapterAssunto> assuntos = chapterAssuntoRepository.getAllChapterAssunto();
        if (assuntos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assuntos);
    }

    @Transactional
    public ChapterAssunto getChapterAssuntoWithTags(Integer id) {
        return chapterAssuntoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void associarTagAAssunto(ChapterAssunto chapterAssunto, List<Integer> chapterTagIds) {
        for (Integer chapterTagId : chapterTagIds) {
            ChapterTag chapterTag = chapterTagRepository.findById(chapterTagId.longValue()).orElse(null);
            if (chapterTag != null) {
                ChapterAssuntoTag chapterAssuntoTag = new ChapterAssuntoTag();
                chapterAssuntoTag.setChapterAssunto(chapterAssunto);
                chapterAssuntoTag.setChapterTag(chapterTag);
                chapterAssuntoTagRepository.save(chapterAssuntoTag);
            }
        }
    }

    public ChapterAssunto postChapterAssunto(ChapterAssunto chapterAssunto) {
        return chapterAssuntoRepository.save(chapterAssunto);
    }
}

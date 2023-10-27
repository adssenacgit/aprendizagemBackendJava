package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.entity.ChapterAssuntoTag;
import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.repository.ChapterAssuntoTagRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChapterAssuntoTagService {
    private final ChapterAssuntoTagRepository chapterAssuntoTagRepository;

    public List<ChapterAssuntoTag> getAllChapterAssuntoTag(){
        return chapterAssuntoTagRepository.findAll();
    }

    public ChapterAssuntoTag postChapterAssuntoTag(ChapterAssunto chapterAssunto, ChapterTag chapterTag){
        ChapterAssuntoTag chapterAssuntoTag = new ChapterAssuntoTag(null, chapterAssunto, chapterTag);
        return chapterAssuntoTagRepository.save(chapterAssuntoTag);
    }


}

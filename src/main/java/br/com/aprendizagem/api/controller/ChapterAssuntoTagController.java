package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.entity.ChapterAssuntoTag;
import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.service.ChapterAssuntoTagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("chapter-assunto-tag")
public class ChapterAssuntoTagController {
    private final ChapterAssuntoTagService chapterAssuntoTagService;

    @GetMapping
    public ResponseEntity<List<ChapterAssuntoTag>> getAllChapterAssuntoTag(){
        return ResponseEntity.ok().body(chapterAssuntoTagService.getAllChapterAssuntoTag());
    }

    @PostMapping
    public ResponseEntity<ChapterAssuntoTag> postChapterAssuntoTag(ChapterAssunto chapterAssunto, ChapterTag chapterTag){
        return ResponseEntity.ok().body(chapterAssuntoTagService.postChapterAssuntoTag(chapterAssunto, chapterTag));
    }

}

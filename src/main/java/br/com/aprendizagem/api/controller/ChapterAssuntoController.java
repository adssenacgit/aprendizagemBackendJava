package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.service.ChapterAssuntoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("chapter-assunto")
@CrossOrigin
public class ChapterAssuntoController {

    private final ChapterAssuntoService chapterAssuntoService;

    @GetMapping
    public ResponseEntity<List<ChapterAssunto>> getAllChapterAssunto(){
        return chapterAssuntoService.getAllChapterAssunto();
    }
}

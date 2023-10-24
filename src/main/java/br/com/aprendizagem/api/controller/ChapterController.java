package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.service.ChapterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chapter")
@AllArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;

    @GetMapping
    public ResponseEntity<List<Chapter>> getAllChapters() {
        List<Chapter> chapters = chapterService.getAllChapters();
        if(chapters.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapters);
    }
}

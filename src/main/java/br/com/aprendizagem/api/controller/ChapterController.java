package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.service.ChapterService;
import br.com.aprendizagem.api.service.GrupoChapterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chapter")
@AllArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;
    private final GrupoChapterService grupoChapterService;

    @GetMapping
    public ResponseEntity<List<Chapter>> getActiveChapters() {
        List<Chapter> chapters = chapterService.getActiveChapters();
        if(chapters.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapters);
    }

    @GetMapping("/noticias")
    public ResponseEntity<Chapter> getNoticiasChapter() {
        Chapter chapter = chapterService.getNoticiasChapter();
        if(chapter == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapter);
    }

    @GetMapping("getChapterByGrupoId/{grupoId}")
    public ResponseEntity<Chapter> getChapterByGrupoId(@PathVariable Long grupoId) {
        return grupoChapterService.getChapterByGrupoId(grupoId);
    }

    @PostMapping
    public ResponseEntity<Chapter> postChapter(@RequestBody Chapter chapter) {
        return ResponseEntity.ok(chapterService.postChapter(chapter));
    }
}
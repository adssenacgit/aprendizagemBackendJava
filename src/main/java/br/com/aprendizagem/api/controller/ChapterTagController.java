package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.service.ChapterTagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chapter-tag")
@AllArgsConstructor
public class ChapterTagController {
    private final ChapterTagService chapterTagService;

    @GetMapping
    public ResponseEntity<List<ChapterTag>> getAllChapterTags() {
        List<ChapterTag> chapterTags = chapterTagService.getAllChapterTags();
        if(chapterTags.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapterTags);
    }

    @GetMapping("active")
    public ResponseEntity<List<ChapterTag>> getAllActiveChapterTags() {
        List<ChapterTag> chapterTags = chapterTagService.getAllActiveChapterTags();
        if(chapterTags.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapterTags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterTag> getChapterTagById(@PathVariable Long id) {
        ChapterTag chapterTag = chapterTagService.getChapterTagById(id);
        if(chapterTag == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapterTag);
    }

    @PostMapping
    public ResponseEntity<ChapterTag> postChapterTag(ChapterTag chapterTag) {
        try {
            return ResponseEntity.ok(chapterTagService.postChapterTag(chapterTag));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapterTag(@PathVariable Long id) {
        chapterTagService.deleteChapterTag(id);
        return ResponseEntity.ok().build();
    }
}

package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.service.ChapterTagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chapter-tag")
@AllArgsConstructor
public class ChapterTagController {
    private final ChapterTagService chapterTagService;

    public ResponseEntity<List<ChapterTag>> getAllChapterTags() {
        List<ChapterTag> chapterTags = chapterTagService.getAllChapterTags();
        if(chapterTags.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapterTags);
    }

    public ResponseEntity<List<ChapterTag>> getAllActiveChapterTags() {
        List<ChapterTag> chapterTags = chapterTagService.getAllActiveChapterTags();
        if(chapterTags.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapterTags);
    }

    public ResponseEntity<ChapterTag> getChapterTagById(Long id) {
        ChapterTag chapterTag = chapterTagService.getChapterTagById(id);
        if(chapterTag == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chapterTag);
    }

    public ResponseEntity<ChapterTag> postChapterTag(ChapterTag chapterTag) {
        return ResponseEntity.ok(chapterTagService.postChapterTag(chapterTag));
    }

    public ResponseEntity<ChapterTag> putChapterTag(ChapterTag chapterTag) {
        return ResponseEntity.ok(chapterTagService.putChapterTag(chapterTag));
    }

    public ResponseEntity<Void> deleteChapterTag(Long id) {
        chapterTagService.deleteChapterTag(id);
        return ResponseEntity.ok().build();
    }
}

package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.service.ChapterAssuntoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("chapter-assunto")
@CrossOrigin
public class ChapterAssuntoController {

    private final ChapterAssuntoService chapterAssuntoService;

    @GetMapping
    public ResponseEntity<List<ChapterAssunto>> getAllChapterAssunto() {
        return chapterAssuntoService.getAllChapterAssunto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterAssunto> getChapterAssuntoWithTags(@PathVariable Integer id) {
        ChapterAssunto chapterAssunto = chapterAssuntoService.getChapterAssuntoWithTags(id);
        if (chapterAssunto != null) {
            return ResponseEntity.ok(chapterAssunto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filtrar-chapter-assuntos-por-chapter-id/{chapterId}")
    public ResponseEntity<List<ChapterAssunto>> filterChapterAssuntosByChapterId(@PathVariable Integer chapterId){
        return chapterAssuntoService.filterChapterAssuntosByChapterId(chapterId);
    }

    @PostMapping()
    public ResponseEntity<ChapterAssunto> postChapterAssunto(@RequestBody ChapterAssunto chapterAssunto) {
        try {
            chapterAssunto.setDataCadastro(LocalDateTime.now());
            return ResponseEntity.ok(chapterAssuntoService.postChapterAssunto(chapterAssunto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

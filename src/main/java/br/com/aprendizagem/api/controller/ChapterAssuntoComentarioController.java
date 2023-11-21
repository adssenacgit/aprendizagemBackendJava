package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
import br.com.aprendizagem.api.service.ChapterAssuntoComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chapter-assunto-comentario")
@AllArgsConstructor
public class ChapterAssuntoComentarioController {

    private final ChapterAssuntoComentarioService chapterAssuntoComentarioService;

    @GetMapping
    public ResponseEntity<List<ChapterAssuntoComentario>> getAllChapterAssuntoComentario() {
        return ResponseEntity.ok().body(chapterAssuntoComentarioService.getAllChapterAssuntoComentario());
    }

    @GetMapping("/comentarios-pai")
    public ResponseEntity<List<ChapterAssuntoComentario>> findAllComentarioPai() {
        List<ChapterAssuntoComentario> chapterAssuntoComentarios = chapterAssuntoComentarioService.findAllComentarioPai();
        if (chapterAssuntoComentarios != null) {
            return ResponseEntity.ok().body(chapterAssuntoComentarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterAssuntoComentario> getChapterAssuntoComentarioById(@PathVariable Integer id) {
        ChapterAssuntoComentario chapterAssuntoComentario = chapterAssuntoComentarioService.getChapterAssuntoComentarioById(id);
        if (chapterAssuntoComentario != null) {
            return ResponseEntity.ok().body(chapterAssuntoComentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filtrar-por-chapter-assunto-id/{chapterAssuntoId}")
    public ResponseEntity<List<ChapterAssuntoComentario>> filterByChapterAssuntoId(@PathVariable Integer chapterAssuntoId) {
        List<ChapterAssuntoComentario> chapterAssuntoComentario = chapterAssuntoComentarioService.filterByChapterAssuntoId(chapterAssuntoId);
        if (chapterAssuntoComentario != null) {
            return ResponseEntity.ok().body(chapterAssuntoComentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filtrar-por-chapter-assunto-id-comentarios-pai/{chapterAssuntoId}")
    public ResponseEntity<List<ChapterAssuntoComentario>> findAllComentarioPaiByChapterAssuntoId(@PathVariable Integer chapterAssuntoId) {
        List<ChapterAssuntoComentario> chapterAssuntoComentarios = chapterAssuntoComentarioService.findAllComentarioPaiByChapterAssuntoId(chapterAssuntoId);
        if (chapterAssuntoComentarios != null) {
            return ResponseEntity.ok().body(chapterAssuntoComentarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ChapterAssuntoComentario> postChapterAssuntoComentario(@RequestBody ChapterAssuntoComentario chapterAssuntoComentario) {
        return ResponseEntity.ok().body(chapterAssuntoComentarioService.postChapterAssuntoComentario(chapterAssuntoComentario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapterAssuntoComentarioById(@PathVariable Integer id) {
        chapterAssuntoComentarioService.deleteChapterAssuntoComentarioById(id);
        return ResponseEntity.noContent().build();
    }

}

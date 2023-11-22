package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.DTO.ChapterAssuntoComentarioDto;
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



    @GetMapping()
    public ResponseEntity<List<ChapterAssuntoComentarioDto>> getAllChapterAssuntoComentario() {
        return ResponseEntity.ok().body(chapterAssuntoComentarioService.getAllChapterAssuntoComentarioDto());
    }

    @GetMapping("/comentarios-by-chapter-assunto-id/{chapterAssuntoId}")
    public ResponseEntity<List<ChapterAssuntoComentarioDto>> getAllChapterAssuntoComentarioDtoByChapterAssuntoId(@PathVariable Integer chapterAssuntoId) {
        return ResponseEntity.ok().body(chapterAssuntoComentarioService.getAllChapterAssuntoComentarioDtoByChapterAssuntoId(chapterAssuntoId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ChapterAssuntoComentario> getChapterAssuntoComentarioById(@PathVariable Long id) {
        ChapterAssuntoComentario chapterAssuntoComentario = chapterAssuntoComentarioService.getChapterAssuntoComentarioById(id);
        if (chapterAssuntoComentario != null) {
            return ResponseEntity.ok().body(chapterAssuntoComentario);
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

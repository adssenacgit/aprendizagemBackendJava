package br.com.aprendizagem.api.controller;

import br.com.aprendizagem.api.DTO.ChapterAssuntoDto;
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


    @GetMapping()
    public ResponseEntity<List<ChapterAssuntoDto>> getAllChapterAssunto() {
        return chapterAssuntoService.getAllChapterAssuntoDto();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ChapterAssuntoDto> getChapterAssuntoById(@PathVariable Integer id) {
        ChapterAssuntoDto chapterAssuntoDTO = chapterAssuntoService.getChapterAssuntoById(id);
        if (chapterAssuntoDTO != null) {
            return ResponseEntity.ok().body(chapterAssuntoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filtrar-chapter-assuntos-por-chapter-id/{chapterId}")
    public ResponseEntity<List<ChapterAssunto>> filterChapterAssuntosByChapterId(@PathVariable Integer chapterId) {
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

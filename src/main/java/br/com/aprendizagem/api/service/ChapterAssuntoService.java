package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.repository.ChapterAssuntoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ChapterAssuntoService {
    private final ChapterAssuntoRepository chapterAssuntoRepository;
    @Transactional
    public ResponseEntity<List<ChapterAssunto>> getAllChapterAssunto(){
        List<ChapterAssunto> assuntos = chapterAssuntoRepository.getAllChapterAssunto();
        if(assuntos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assuntos);
    }
}

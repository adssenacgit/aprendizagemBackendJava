package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.entity.GrupoChapter;
import br.com.aprendizagem.api.repository.GrupoChapterRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GrupoChapterService {
    private final GrupoChapterRespository grupoChapterRespository;
    @Transactional
    public ResponseEntity<Chapter> getChapterByGrupoId(Long grupoId) {
        Optional<GrupoChapter> optGrupoChapter = grupoChapterRespository.findByGrupoId(grupoId);
        if (optGrupoChapter.isPresent()) {
            Chapter chapter = optGrupoChapter.get().getChapter();
            return ResponseEntity.ok(chapter);
        }
        return ResponseEntity.notFound().build();
    }
}

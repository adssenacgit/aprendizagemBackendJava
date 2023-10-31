package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Atividade;
import br.com.aprendizagem.api.repository.AtividadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AtividadeService {
    private final AtividadeRepository atividadeRepository;

    @Transactional
    public ResponseEntity<List<Atividade>> getActiveAtividades() {
        List<Atividade> atividades = atividadeRepository.getActiveAtividades();
        if (atividades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atividades);
    }
}

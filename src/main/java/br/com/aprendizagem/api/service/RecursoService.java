package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.repository.RecursoRepository;
import br.com.aprendizagem.api.response.RecursoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecursoService {
    private final RecursoRepository recursoRepository;

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getAllRecursos() {
        List<Recurso> recursos = recursoRepository.findAll();
        if( recursos.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RecursoResponse.of(recursos));
    }

    @Transactional
    public Recurso getRecursoById(Long id) {
        return recursoRepository.findById(id).orElse(null);
    }
}

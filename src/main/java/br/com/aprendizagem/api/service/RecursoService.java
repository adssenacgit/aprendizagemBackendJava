package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.entity.Usuario;
import br.com.aprendizagem.api.repository.RecursoRepository;
import br.com.aprendizagem.api.response.RecursoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getActiveRecursos() {
        List<Recurso> recursos = recursoRepository.getActiveRecursos();
        if( recursos.isEmpty()){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(RecursoResponse.of(recursos));
    }

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getActiveRecursosSemArquivo() {
        List<RecursoResponse> recursos = recursoRepository.getActiveRecursosSemArquivo();

        if (recursos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recursos);
    }

    @Transactional
    public ResponseEntity<List<RecursoResponse>> getActiveRecursosByUsuarioIdSemArquivo(String usuarioId) {
        List<RecursoResponse> recursos = recursoRepository.getActiveRecursosByUsuarioIdSemArquivo(usuarioId);

        if (recursos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(recursos);
    }
}

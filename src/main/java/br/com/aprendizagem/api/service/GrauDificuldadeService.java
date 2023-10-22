package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.GrauDificuldade;
import br.com.aprendizagem.api.repository.GrauDificuldadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GrauDificuldadeService {

    private final GrauDificuldadeRepository grauDificuldadeRepository;
    public ResponseEntity<List<GrauDificuldade>> getAllGrausDificuldade() {
        List<GrauDificuldade> dificuldades = grauDificuldadeRepository.findAll();
        if(dificuldades.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dificuldades);
    }
}

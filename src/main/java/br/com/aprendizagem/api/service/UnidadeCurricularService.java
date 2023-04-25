package br.com.aprendizagem.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Modulo;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import br.com.aprendizagem.api.repository.UnidadeCurricularRepository;
import br.com.aprendizagem.api.response.UnidadeCurricularResponse;
import lombok.AllArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Service
@AllArgsConstructor
public class UnidadeCurricularService {

    private UnidadeCurricularRepository unidadeCurricularRepository;

    // private static Map<Long, UnidadeCurricular> listaUnidadesCurriculares = new
    // HashMap<>();

    @Transactional
    public ResponseEntity<UnidadeCurricularResponse> listarUnidadeCurricularPorModulo(Long id) {
        Optional<UnidadeCurricular> unidadeOpt = unidadeCurricularRepository.findById(id);
        if (!unidadeOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UnidadeCurricularResponse.of(unidadeOpt.get()));
    }

    @Transactional
    public ResponseEntity<List<UnidadeCurricularResponse>> listarUnidadesCurriculares() {
        List<UnidadeCurricular> unidadesCurriculares = unidadeCurricularRepository.findAll();
        if (unidadesCurriculares.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UnidadeCurricularResponse.of(unidadesCurriculares));
        // return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

}

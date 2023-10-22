package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.repository.EncontroRepository;
import br.com.aprendizagem.api.response.EncontroResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class EncontroService {

    public final EncontroRepository encontroRepository;
    public ResponseEntity<List<Encontro>> getAllEncontros() {
        List<Encontro> encontros = encontroRepository.findAll();
        if (encontros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontros);
    }

    @Transactional
    public ResponseEntity<List<EncontroResponse>> getEncontrosByGrupoId(Long id) {
        List<Encontro> encontros = encontroRepository.findByGrupoId(id);
        if (encontros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(EncontroResponse.of(encontros));
    }
}

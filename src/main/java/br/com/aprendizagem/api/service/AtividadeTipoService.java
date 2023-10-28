package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.AtividadeTipo;
import br.com.aprendizagem.api.repository.AtividadeTipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class AtividadeTipoService {
    private final AtividadeTipoRepository atividadeTipoRepository;

    @Transactional
    public ResponseEntity<List<AtividadeTipo>> getAllAtividadeTipo() {
        List<AtividadeTipo> atividadeTipos = atividadeTipoRepository.findAll();
        if(atividadeTipos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atividadeTipos);
    }
}

package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import br.com.aprendizagem.api.repository.ObjetoAprendizagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ObjetoAprendizagemService {
    private final ObjetoAprendizagemRepository objetoAprendizagemRepository;

    @Transactional
    public ResponseEntity<List<ObjetoAprendizagem>> getAllObjetosAprendizagem() {
        List<ObjetoAprendizagem> objetos = objetoAprendizagemRepository.findAll();
        if (objetos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objetos);
    }
}

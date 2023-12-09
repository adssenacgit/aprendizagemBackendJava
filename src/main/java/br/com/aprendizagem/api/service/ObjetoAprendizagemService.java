package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.entity.Usuario;
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
        List<ObjetoAprendizagem> objetos = objetoAprendizagemRepository.findAllWithRecursos();
        if (objetos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objetos);
    }

    @Transactional
    public ObjetoAprendizagem getArquivoObjetoById(Long id) {
        return objetoAprendizagemRepository.findById(id).orElse(null);
    }

    @Transactional
    public ObjetoAprendizagem getObjetoAprendizagemById(Long objetoAprendizagemId) {
        return objetoAprendizagemRepository.findById(objetoAprendizagemId).orElse(null);
    }
    @Transactional
    public ResponseEntity<ObjetoAprendizagem> getObjetoWithRecursosByObjetoId(Long objetoId) {
        ObjetoAprendizagem objetoAprendizagem = objetoAprendizagemRepository.findByIdWithRecursos(objetoId);
        if (objetoAprendizagem != null) {
            return ResponseEntity.ok(objetoAprendizagem);
        }
        return ResponseEntity.notFound().build();
    }
    @Transactional
    public ResponseEntity<ObjetoAprendizagem> createObjeto(ObjetoAprendizagem objeto) {
        return ResponseEntity.ok(objetoAprendizagemRepository.save(objeto));
    }
}

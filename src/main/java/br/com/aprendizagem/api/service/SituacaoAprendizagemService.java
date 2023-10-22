package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import br.com.aprendizagem.api.repository.SituacaoAprendizagemRepository;
import br.com.aprendizagem.api.response.SituacaoAprendizagemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SituacaoAprendizagemService {
    private final SituacaoAprendizagemRepository situacaoAprendizagemRepository;

    @Transactional
    public ResponseEntity<List<SituacaoAprendizagemResponse>> getAllSituacoesAprendizagem() {
        List<SituacaoAprendizagem> situacoes = situacaoAprendizagemRepository.findAll();
        if(situacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(SituacaoAprendizagemResponse.of(situacoes));
    }

    public ResponseEntity<SituacaoAprendizagem> getSituacaoAprendizagemById(Long id) {
        Optional<SituacaoAprendizagem> situacaoOpt = situacaoAprendizagemRepository.findById(id);
        if(situacaoOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok((situacaoOpt.get()));
    }
}

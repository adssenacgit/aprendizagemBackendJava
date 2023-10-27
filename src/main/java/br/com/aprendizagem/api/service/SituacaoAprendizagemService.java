package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import br.com.aprendizagem.api.entity.SituacaoEncontro;
import br.com.aprendizagem.api.repository.SituacaoAprendizagemRepository;
import br.com.aprendizagem.api.repository.SituacaoEncontroRepository;
import br.com.aprendizagem.api.response.SituacaoAprendizagemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SituacaoAprendizagemService {
    private final SituacaoAprendizagemRepository situacaoAprendizagemRepository;
    private final SituacaoEncontroService situacaoEncontroService;

    @Transactional
    public ResponseEntity<List<SituacaoAprendizagemResponse>> getAllSituacoesAprendizagem() {
        List<SituacaoAprendizagem> situacoes = situacaoAprendizagemRepository.findAll();
        if(situacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(SituacaoAprendizagemResponse.of(situacoes));
    }

    @Transactional
    public ResponseEntity<SituacaoAprendizagem> getSituacaoAprendizagemById(Long id) {
        Optional<SituacaoAprendizagem> situacaoOpt = situacaoAprendizagemRepository.findById(id);
        return situacaoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @Transactional
    public ResponseEntity<List<SituacaoAprendizagem>> getSituacoesAprendizagemByEncontroId(Long encontroId) {
       return situacaoEncontroService.getSituacoesAprendizagemByEncontroId(encontroId);
    }
}

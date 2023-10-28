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
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(SituacaoAprendizagemResponse.of(situacoes));
    }

    @Transactional
    public ResponseEntity<SituacaoAprendizagemResponse> getSituacaoAprendizagemById(Long id) {
        SituacaoAprendizagem situacaoAprendizagem = situacaoAprendizagemRepository.findById(id).orElse(null);
        if (situacaoAprendizagem == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(SituacaoAprendizagemResponse.of(situacaoAprendizagem));
    }

    @Transactional
    public ResponseEntity<List<SituacaoAprendizagem>> getSituacoesAprendizagemByEncontroId(Long encontroId) {
       return situacaoEncontroService.getSituacoesAprendizagemByEncontroId(encontroId);
    }
}

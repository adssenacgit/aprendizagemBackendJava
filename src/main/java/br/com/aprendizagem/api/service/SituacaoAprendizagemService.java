package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.*;
import br.com.aprendizagem.api.repository.*;
import br.com.aprendizagem.api.request.SituacaoAprendizagemRequest;
import br.com.aprendizagem.api.response.SituacaoAprendizagemResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SituacaoAprendizagemService {
    private final SituacaoAprendizagemRepository situacaoAprendizagemRepository;
    private final SituacaoEncontroService situacaoEncontroService;
    private final PlanejamentoUcRepository planejamentoUcRepository;
    private final GrauDificuldadeRepository grauDificuldadeRepository;
    private final BadgeRepository badgeRepository;

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

    @Transactional
    public ResponseEntity<List<SituacaoAprendizagemResponse>> getSituacoesAprendizagemByPlanejamentoUcId(Long planejamentoUcId) {
        List<SituacaoAprendizagem> situacoes = situacaoAprendizagemRepository.findByPlanejamentoUc_Id(planejamentoUcId);
        if(situacoes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(SituacaoAprendizagemResponse.of(situacoes));
    }

    @Transactional
    public ResponseEntity<SituacaoAprendizagem> createSituacaoAprendizagem(SituacaoAprendizagemRequest situacaoRequest) {
        SituacaoAprendizagem novaSituacao = new SituacaoAprendizagem();
        novaSituacao.setTitulo(situacaoRequest.getTitulo());
        novaSituacao.setDescricao(situacaoRequest.getDescricao());
        novaSituacao.setOrdem(situacaoRequest.getOrdem());
        novaSituacao.setDuracao(situacaoRequest.getDuracao());
        novaSituacao.setStatus(1);
        novaSituacao.setInicio(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        novaSituacao.setFim(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        PlanejamentoUc planejamentoUc = planejamentoUcRepository.findById(situacaoRequest.getPlanejamentoUcId()).orElse(null);
        novaSituacao.setPlanejamentoUc(planejamentoUc);
        GrauDificuldade grauDificuldade = grauDificuldadeRepository.findById(situacaoRequest.getGrauDificuldadeId()).orElse(null);
        novaSituacao.setGrauDificuldade(grauDificuldade);
        Badge badge = badgeRepository.findById(situacaoRequest.getBadgeId()).orElse(null);
        novaSituacao.setBadge(badge);

        return ResponseEntity.ok(situacaoAprendizagemRepository.save(novaSituacao));
    }
@Transactional
    public ResponseEntity<SituacaoAprendizagem> updateSituacaoAprendizagem(Long id, SituacaoAprendizagem situacaoAprendizagem) {
        SituacaoAprendizagem situacaoAprendizagemExistente = situacaoAprendizagemRepository.findById(id).orElse(null);
        if(situacaoAprendizagemExistente != null) {
            BeanUtils.copyProperties(situacaoAprendizagem, situacaoAprendizagemExistente);
            return ResponseEntity.ok(situacaoAprendizagemRepository.save(situacaoAprendizagem));
        }
        return ResponseEntity.notFound().build();
    }
}

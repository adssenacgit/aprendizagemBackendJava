package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Acompanhamento;
import br.com.aprendizagem.api.repository.AcompanhamentoRepository;
import br.com.aprendizagem.api.response.AcompanhamentoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AcompanhamentoService {

    private final AcompanhamentoRepository acompanhamentoRepository;


    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponse() {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.getActiveAcompanhamentos();
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public Acompanhamento getAcompanhamentoById(Long id) {
        Acompanhamento acompanhamento = acompanhamentoRepository.findById(id).orElse(null);
        if (acompanhamento != null && acompanhamento.getStatus() == 1) {
            return acompanhamento;
        }
        return null;
    }

    @Transactional
    public Acompanhamento postAcompanhamento(Acompanhamento acompanhamento) {
        return acompanhamentoRepository.save(acompanhamento);
    }
    @Transactional
    public ResponseEntity<List<Acompanhamento>> getActiveAcompanhamentos() {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.getActiveAcompanhamentos();
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(acompanhamentos);
    }

    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponseByGrupoIdByEstudanteId(Long grupoId, Long estudanteId) {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByParticipante_Grupo_IdAndParticipante_Estudante_Id(grupoId, estudanteId);
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponseByEstudanteId(Long estudanteId) {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByParticipante_Estudante_Id(estudanteId);
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponseByAtividadeIdByEstudanteId(Long atividadeId, Long estudanteId) {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByAtividade_IdAndParticipante_Estudante_Id(atividadeId, estudanteId);
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponseByObjetoIdByEstudanteId(Long objetoId, Long estudanteId) {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByObjetoAprendizagem_IdAndParticipante_Estudante_Id(objetoId, estudanteId);
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponseByGrupoIdByEstudanteIdByAtividadeId(Long grupoId, Long estudanteId, Long atividadeId) {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByParticipante_Grupo_IdAndParticipante_Estudante_IdAndAtividade_Id(grupoId, estudanteId, atividadeId);
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public ResponseEntity<List<AcompanhamentoResponse>> getAcompanhamentosResponseByGrupoIdByEstudanteIdByObjetoId(Long grupoId, Long estudanteId, Long objetoId) {
        List<Acompanhamento> acompanhamentos = acompanhamentoRepository.findByParticipante_Grupo_IdAndParticipante_Estudante_IdAndObjetoAprendizagem_Id(grupoId, estudanteId, objetoId);
        if(acompanhamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public Integer getTotalAcompanhamentosByParticipanteId(Long participanteId) {
        return acompanhamentoRepository.countByParticipante_Id(participanteId);
    }


}

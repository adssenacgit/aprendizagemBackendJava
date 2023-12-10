package br.com.aprendizagem.api.service;

import br.com.aprendizagem.api.entity.Acompanhamento;
import br.com.aprendizagem.api.entity.Atividade;
import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.repository.AcompanhamentoRepository;
import br.com.aprendizagem.api.request.AcompanhamentoRequest;
import br.com.aprendizagem.api.response.AcompanhamentoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AcompanhamentoService {

    private final AcompanhamentoRepository acompanhamentoRepository;
    private final ObjetoAprendizagemService objetoAprendizagemService;

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
            return ResponseEntity.notFound().build();
        }
        acompanhamentos = acompanhamentos.stream().filter(acompanhamento -> acompanhamento.getStatus() != -1).collect(Collectors.toList());
        return ResponseEntity.ok(AcompanhamentoResponse.of(acompanhamentos));
    }

    @Transactional
    public Integer getTotalAcompanhamentosByParticipanteId(Long participanteId) {
        return acompanhamentoRepository.countActiveByParticipanteId(participanteId);
    }

    @Transactional
    public ResponseEntity<Acompanhamento> createAcompanhamento(AcompanhamentoRequest acompanhamentoRequest) {

        Optional<Acompanhamento> optAcompanhamentoExistente = acompanhamentoRepository.findByObjetoAprendizagem_IdAndParticipante_Estudante_Id(
                acompanhamentoRequest.getObjetoAprendizagemId(),
                acompanhamentoRequest.getParticipante().getEstudante().getId())
                .stream().filter(acompanhamento -> acompanhamento.getStatus() != -1).findFirst();
        if(optAcompanhamentoExistente.isEmpty()){
            Acompanhamento acompanhamento = new Acompanhamento();
            acompanhamento.setEntrega(acompanhamentoRequest.getEntrega());
            if(acompanhamento.getEntrega() == null) {
                acompanhamento.setEntrega("0");
            }
            acompanhamento.setEntregaArquivo(acompanhamentoRequest.getEntregaArquivo());
            acompanhamento.setInicio(acompanhamentoRequest.getInicio());
            acompanhamento.setFinalizacao(acompanhamentoRequest.getFinalizacao());
            acompanhamento.setStatus(acompanhamentoRequest.getStatus());
            acompanhamento.setParticipante(acompanhamentoRequest.getParticipante());
            acompanhamento.setAvaliacaoConceitoId(acompanhamentoRequest.getAvaliacaoConceitoId());
//        Atividade atividade = atividadeService.getAtividadeById(acompanhamentoRequest.getAtividade().getId());
            acompanhamento.setAtividade(acompanhamentoRequest.getAtividade());
            ObjetoAprendizagem objetoAprendizagem = objetoAprendizagemService.getObjetoAprendizagemById(acompanhamentoRequest.getObjetoAprendizagemId());
            acompanhamento.setObjetoAprendizagem(objetoAprendizagem);
            acompanhamento.setSituacaoAprendizagemId(acompanhamentoRequest.getSituacaoAprendizagemId());
            acompanhamento.setBadgeId(acompanhamentoRequest.getBadgeId());
            acompanhamento.setDataBadge(acompanhamentoRequest.getDataBadge());
            acompanhamento.setAtividadePerguntaRespostaId(acompanhamentoRequest.getAtividadePerguntaRespostaId());
            return ResponseEntity.ok(acompanhamentoRepository.save(acompanhamento));
        }
       else {
           Acompanhamento acompanhamento = optAcompanhamentoExistente.get();
           if(acompanhamento.getStatus() == 1) {
               acompanhamento.setStatus(0);
           }
           else {
               acompanhamento.setStatus(1);
           }
           return ResponseEntity.ok(acompanhamentoRepository.save(acompanhamento));
        }
    }
}

package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoResponse {
    private Long id;
    private String entrega;
    private byte[] entregaArquivo;
    private LocalDateTime inicio;
    private LocalDateTime finalizacao;
    private Integer status;
    private ParticipanteResponse participante;
    private Integer avaliacaoConceitoId;
    private Long atividadeId;
    private Long objetoAprendizagemId;
    private Long situacaoAprendizagemId;
    private Integer badgeId;
    private LocalDateTime dataBadge;
    private Long atividadePerguntaRespostaId;

    public static AcompanhamentoResponse of (Acompanhamento acompanhamento) {
        return AcompanhamentoResponse.builder()
                .id(acompanhamento.getId())
                .entrega(acompanhamento.getEntrega())
                .entregaArquivo(acompanhamento.getEntregaArquivo())
                .inicio(acompanhamento.getInicio())
                .finalizacao(acompanhamento.getFinalizacao())
                .status(acompanhamento.getStatus())
                .participante(ParticipanteResponse.of(acompanhamento.getParticipante()))
                .avaliacaoConceitoId(acompanhamento.getAvaliacaoConceitoId())
                .atividadeId(acompanhamento.getAtividadeId())
                .objetoAprendizagemId(acompanhamento.getObjetoAprendizagemId())
                .situacaoAprendizagemId(acompanhamento.getSituacaoAprendizagemId())
                .badgeId(acompanhamento.getBadgeId())
                .dataBadge(acompanhamento.getDataBadge())
                .atividadePerguntaRespostaId(acompanhamento.getAtividadePerguntaRespostaId())
                .build();
    }

    public static List<AcompanhamentoResponse> of (List<Acompanhamento> acompanhamentos) {
        List<AcompanhamentoResponse> acompanhamentoResponses = new ArrayList<>();
        for (Acompanhamento acompanhamento : acompanhamentos) {
            acompanhamentoResponses.add(of(acompanhamento));
        }
        return acompanhamentoResponses;
    }
}

package br.com.aprendizagem.api.request;

import br.com.aprendizagem.api.entity.Atividade;
import br.com.aprendizagem.api.entity.ObjetoAprendizagem;
import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoRequest {
    private String entrega;
    private byte[] entregaArquivo;
    private LocalDateTime inicio;
    private LocalDateTime finalizacao;
    private Integer status;
    private Participante participante;
    private Integer avaliacaoConceitoId;
    private Atividade atividade;
    private Long objetoAprendizagemId;
    private Long situacaoAprendizagemId;
    private Integer badgeId;
    private LocalDateTime dataBadge;
    private Long atividadePerguntaRespostaId;
}

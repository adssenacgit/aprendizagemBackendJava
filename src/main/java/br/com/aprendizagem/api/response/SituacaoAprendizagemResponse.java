package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoAprendizagemResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer ordem;
    private Integer status;
    private PlanejamentoUc planejamentoUc;
    private GrauDificuldade grauDificuldade;
    private Badge badge;
    private List<ObjetoAprendizagemResponse> objetosAprendizagem;
    private List<Atividade> atividades;
    public static SituacaoAprendizagemResponse of (SituacaoAprendizagem situacaoAprendizagem) {
        return SituacaoAprendizagemResponse.builder()
                .id(situacaoAprendizagem.getId())
                .titulo(situacaoAprendizagem.getTitulo())
                .descricao(situacaoAprendizagem.getDescricao())
                .ordem(situacaoAprendizagem.getOrdem())
                .status(situacaoAprendizagem.getStatus())
                .planejamentoUc(situacaoAprendizagem.getPlanejamentoUc())
                .grauDificuldade(situacaoAprendizagem.getGrauDificuldade())
                .badge(situacaoAprendizagem.getBadge())
                .objetosAprendizagem(ObjetoAprendizagemResponse.of(situacaoAprendizagem.getObjetosAprendizagem()))
                .atividades(situacaoAprendizagem.getAtividades())
                .build();
    }

    public static List<SituacaoAprendizagemResponse> of (List<SituacaoAprendizagem> situacoes) {
        List<SituacaoAprendizagemResponse> situacoesResponse = new ArrayList<>();
        for ( SituacaoAprendizagem situacao : situacoes) {
            situacoesResponse.add(SituacaoAprendizagemResponse.of(situacao));
        }
        return situacoesResponse;
    }
}

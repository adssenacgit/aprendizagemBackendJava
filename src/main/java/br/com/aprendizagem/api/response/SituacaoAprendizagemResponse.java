package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.Badge;
import br.com.aprendizagem.api.entity.GrauDificuldade;
import br.com.aprendizagem.api.entity.PlanejamentoUc;
import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

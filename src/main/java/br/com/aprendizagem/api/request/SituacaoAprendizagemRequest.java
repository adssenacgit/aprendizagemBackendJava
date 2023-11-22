package br.com.aprendizagem.api.request;

import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoAprendizagemRequest {
    private String titulo;
    private String descricao;
    private Integer ordem;
    private Integer duracao;
    private Integer status;
    private Long planejamentoUcId;
    private Integer grauDificuldadeId;
    private Integer badgeId;
}

package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.Grupo;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrupoResponse {
    private Long id;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Integer status;
    private Integer turnoId;
    private UnidadeCurricular unidadeCurricular;
    private Long periodoId;
    private Long professorId;

    public static GrupoResponse of (Grupo grupo) {
        return GrupoResponse.builder()
                .id(grupo.getId())
                .descricao(grupo.getDescricao())
                .dataInicio(grupo.getDataInicio())
                .dataFim(grupo.getDataFim())
                .status(grupo.getStatus())
                .turnoId(grupo.getTurnoId())
                .unidadeCurricular(grupo.getUnidadeCurricular())
                .periodoId(grupo.getPeriodo().getId())
                .professorId(grupo.getProfessorId())
                .build();
    }

    public static List<GrupoResponse> of(List<Grupo> grupos) {
        List<GrupoResponse> grupoResponses = new ArrayList<>();
        for (Grupo grupo : grupos) {
            grupoResponses.add(of(grupo));
        }
        return grupoResponses;
    }


}

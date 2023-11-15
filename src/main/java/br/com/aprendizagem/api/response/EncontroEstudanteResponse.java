package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.DiaLetivo;
import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.entity.EncontroTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncontroEstudanteResponse {

    private Long id;
    private String observacao;
    private DiaLetivo diaLetivo;
    private Long grupoId;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    private String local;
    private Integer status;
    private EncontroTipo encontroTipo;
    private List<SituacaoAprendizagemResponse> situacoesAprendizagem;
    private Integer presenca;

    public static EncontroEstudanteResponse of (Encontro encontro, Integer presenca) {
        return EncontroEstudanteResponse.builder()
                .id(encontro.getId())
                .observacao(encontro.getObservacao())
                .diaLetivo(encontro.getDiaLetivo())
                .grupoId(encontro.getGrupo().getId())
                .horaInicio(encontro.getHoraInicio())
                .horaFim(encontro.getHoraFim())
                .local(encontro.getLocal())
                .status(encontro.getStatus())
                .encontroTipo(encontro.getEncontroTipo())
                .situacoesAprendizagem(SituacaoAprendizagemResponse.of(encontro.getSituacoesAprendizagem()))
                .presenca(presenca)
                .build();
    }

//    public static List<EncontroEstudanteResponse> of (List<Encontro> encontros) {
//        List<EncontroEstudanteResponse> encontroEstudanteResponses = new ArrayList<>();
//        for( Encontro encontro : encontros) {
//            encontroEstudanteResponses.add(of(encontro));
//        }
//        return encontroEstudanteResponses;
//    }
}

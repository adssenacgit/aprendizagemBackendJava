package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.DiaLetivo;
import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.entity.EncontroTipo;
import br.com.aprendizagem.api.entity.Grupo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncontroResponse {
    private Long id;
    private String observacao;
    private DiaLetivo diaLetivo;
    private Long grupoId;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    private String local;
    private Integer status;
    private EncontroTipo encontroTipo;

    public static EncontroResponse of (Encontro encontro) {
        return EncontroResponse.builder()
                .id(encontro.getId())
                .observacao(encontro.getObservacao())
                .diaLetivo(encontro.getDiaLetivo())
                .grupoId(encontro.getGrupo().getId())
                .horaInicio(encontro.getHoraInicio())
                .horaFim(encontro.getHoraFim())
                .local(encontro.getLocal())
                .status(encontro.getStatus())
                .encontroTipo(encontro.getEncontroTipo())
                .build();
    }

    public static List<EncontroResponse> of (List<Encontro> encontros) {
        List<EncontroResponse> encontroResponses = new ArrayList<>();
        for( Encontro encontro : encontros) {
            encontroResponses.add(of(encontro));
        }
        return encontroResponses;
    }

}

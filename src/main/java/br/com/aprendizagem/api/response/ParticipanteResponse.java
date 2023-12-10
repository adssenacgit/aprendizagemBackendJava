package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.Estudante;
import br.com.aprendizagem.api.entity.Participante;
import br.com.aprendizagem.api.entity.Usuario;
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
public class ParticipanteResponse {
    private Long id;
    private LocalDateTime dataMatricula;
    private Integer status;
    private Long grupoId;
    private String usuarioId;
    private Estudante estudante;


    public static ParticipanteResponse of(Participante participante){
        return ParticipanteResponse.builder()
                .id(participante.getId())
                .dataMatricula(participante.getDataMatricula())
                .status(participante.getStatus())
                .grupoId(participante.getGrupo().getId())
                .usuarioId(participante.getEstudante().getUsuario().getId())
                .estudante(participante.getEstudante())
                .build();
    }

    public static List<ParticipanteResponse> of(List<Participante> participantes){
        List<ParticipanteResponse> participanteResponses = new ArrayList<>();
        for(Participante participante : participantes){
            participanteResponses.add(of(participante));
        }
        return participanteResponses;
    }
}

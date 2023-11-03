package br.com.aprendizagem.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgressoEstudanteResponse {
    private String progressoEstudante;
    private String progressoUc;
    private int totalObjetos;
    private int totalAtividades;
    private int totalAcompanhados;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static ProgressoEstudanteResponse of (int totalObjetos, int totalAtividades, int totalAcompanhados){
        float progressoEstu = (float) totalAcompanhados/(totalObjetos + totalAtividades) * 100;

        return ProgressoEstudanteResponse.builder()
                .progressoEstudante(df.format(progressoEstu))
                .progressoUc("100")
                .totalObjetos(totalObjetos)
                .totalAtividades(totalAtividades)
                .totalAcompanhados(totalAcompanhados)
                .build();
    }
}

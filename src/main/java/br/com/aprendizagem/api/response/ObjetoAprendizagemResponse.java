package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObjetoAprendizagemResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private Boolean hasArquivo;
    private Integer ordem;
    private Integer status;
    private GrauDificuldade grauDificuldade;
    private List<Recurso> recursos;

    public static ObjetoAprendizagemResponse of (ObjetoAprendizagem objetoAprendizagem){
        return ObjetoAprendizagemResponse.builder()
                .id(objetoAprendizagem.getId())
                .titulo(objetoAprendizagem.getTitulo())
                .descricao(objetoAprendizagem.getDescricao())
                .hasArquivo(objetoAprendizagem.getArquivo() != null)
                .ordem(objetoAprendizagem.getOrdem())
                .status(objetoAprendizagem.getStatus())
                .grauDificuldade(objetoAprendizagem.getGrauDificuldade())
                .build();
    }

    public static List<ObjetoAprendizagemResponse> of (List<ObjetoAprendizagem> objetosAprendizagem) {
        List<ObjetoAprendizagemResponse> objetosResponse = new ArrayList<>();
        for ( ObjetoAprendizagem objeto : objetosAprendizagem) {
            objetosResponse.add(ObjetoAprendizagemResponse.of(objeto));
        }
        return objetosResponse;
    }

    public static List<ObjetoAprendizagemResponse> of (Set<ObjetoAprendizagem> objetosAprendizagem) {
        List<ObjetoAprendizagemResponse> objetosResponse = new ArrayList<>();
        for ( ObjetoAprendizagem objeto : objetosAprendizagem) {
            objetosResponse.add(ObjetoAprendizagemResponse.of(objeto));
        }
        return objetosResponse;
    }
}

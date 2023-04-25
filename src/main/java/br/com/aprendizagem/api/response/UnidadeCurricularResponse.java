package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.UnidadeCurricular;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadeCurricularResponse {
    private Long id;
    private String codigo;
    private byte[] img;
    private String nome;
    private String nomeCurto;
    private Integer horas;
    private Integer ordem;
    private Integer status;

    public static UnidadeCurricularResponse of(UnidadeCurricular unidadeCurricular) {
        return UnidadeCurricularResponse.builder()
                .id(unidadeCurricular.getId())
                .codigo(unidadeCurricular.getCodigo())
                .img(unidadeCurricular.getImg())
                .nome(unidadeCurricular.getNome())
                .nomeCurto(unidadeCurricular.getNomeCurto())
                .horas(unidadeCurricular.getHoras())
                .ordem(unidadeCurricular.getOrdem())
                .status(unidadeCurricular.getStatus())
                .build();
    }

    public static List<UnidadeCurricularResponse> of(List<UnidadeCurricular> unidadeCurriculares) {
        List<UnidadeCurricularResponse> unidadesCurricularesResponses = new ArrayList<>();
        for (UnidadeCurricular unidadeCurricular : unidadeCurriculares) {
            unidadesCurricularesResponses.add(of(unidadeCurricular));
        }
        return unidadesCurricularesResponses;
    }
    
    public static Page<UnidadeCurricularResponse> of(Page<UnidadeCurricular> unidadesCurriculares) {
        List<UnidadeCurricularResponse> unidadesCurricularesResponses = new ArrayList<>();
        for(UnidadeCurricular unidadeCurricular : unidadesCurriculares) {
            unidadesCurricularesResponses.add(of(unidadeCurricular));
        }
        return new PageImpl<UnidadeCurricularResponse>(
            unidadesCurricularesResponses,
            unidadesCurriculares.getPageable(),
            unidadesCurriculares.getTotalElements()
        );
    }
}

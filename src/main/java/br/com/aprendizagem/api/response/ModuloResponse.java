package br.com.aprendizagem.api.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.Modulo;
import br.com.aprendizagem.api.entity.Oferta;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuloResponse {
    private Integer id;
    private String descricao;
    private int cargaHoraria;
    private Oferta oferta;
    private Set<UnidadeCurricular> unidadeCurricular;

    public static ModuloResponse of(Modulo modulo) {
        return ModuloResponse.builder()
                .id(modulo.getId())
                .descricao(modulo.getDescricao())
                .cargaHoraria(modulo.getCargaHoraria())
                .oferta(modulo.getOferta())
                .unidadeCurricular(modulo.getUnidadeCurricular())
                .build();
    }

    public static List<ModuloResponse> of(List<Modulo> modulos){
        List<ModuloResponse> modulosResponses = new ArrayList<>();
        for(Modulo modulo : modulos){
            modulosResponses.add(of(modulo));
        }
        return modulosResponses;
    }

    public static Page<ModuloResponse> of(Page<Modulo> modulos){
        List<ModuloResponse> modulosResponses = new ArrayList<>();
        for(Modulo modulo : modulos){
            modulosResponses.add(of(modulo));
        }
        return new PageImpl<ModuloResponse>(
            modulosResponses,
            modulos.getPageable(),
            modulos.getTotalElements()
        );
    }

}

package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.Encontro;
import br.com.aprendizagem.api.entity.SituacaoAprendizagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncontroSituacaoResponse extends EncontroResponse {
    private List<SituacaoAprendizagem> situacoesAprendizagem;


//    public static EncontroSituacaoResponse of(Encontro encontro) {
//
//    }

}

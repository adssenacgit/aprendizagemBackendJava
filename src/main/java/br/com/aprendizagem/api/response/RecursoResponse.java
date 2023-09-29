package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.entity.Usuario;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class RecursoResponse {
    private Long id;
    private String descricao;
    private String nomeArquivo;
    private LocalDateTime dataCadastro;
    private Integer status;
    private UsuarioResponse usuario;


    public static RecursoResponse of(Recurso recurso) {
        return RecursoResponse.builder()
                .id(recurso.getId())
                .descricao(recurso.getDescricao())
                .nomeArquivo(recurso.getNomeArquivo())
                .dataCadastro(recurso.getDataCadastro())
                .status(recurso.getStatus())
                .usuario(UsuarioResponse.of(recurso.getUsuario()))
                .build();
    }

    public static List<RecursoResponse> of(List<Recurso> recursos) {
        List<RecursoResponse> recursoResponses = new ArrayList<>();
        for (Recurso recurso : recursos){
            recursoResponses.add(of(recurso));
        }
        return recursoResponses;
    }
}

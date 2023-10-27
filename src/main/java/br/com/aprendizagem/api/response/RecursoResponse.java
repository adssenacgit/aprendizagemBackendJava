package br.com.aprendizagem.api.response;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.entity.Usuario;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecursoResponse {
    private Long id;
    private String descricao;
    private String nomeArquivo;
    private String mimeType;
    private LocalDateTime dataCadastro;
    private Integer status;
    private Integer tamanho;
    private Usuario usuario;


    public static RecursoResponse of(Recurso recurso) {
        return RecursoResponse.builder()
                .id(recurso.getId())
                .descricao(recurso.getDescricao())
                .nomeArquivo(recurso.getNomeArquivo())
                .mimeType(recurso.getMimeType())
                .dataCadastro(recurso.getDataCadastro())
                .status(recurso.getStatus())
                .tamanho(recurso.getTamanho())
                .usuario(recurso.getUsuario())
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

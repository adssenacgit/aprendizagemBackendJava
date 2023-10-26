package br.com.aprendizagem.api.request;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.entity.Usuario;
import br.com.aprendizagem.api.response.RecursoResponse;
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

public class RecursoRequest {

    private Long id;
    private String descricao;
    private String nomeArquivo;
    private byte[] arquivo;
    private String mimeType;
    private LocalDateTime dataCadastro;
    private Integer status;
    private String usuarioId;

}

package br.com.aprendizagem.api.DTO;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
import br.com.aprendizagem.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentariosFilhosDto {

    private Long id;
    private String texto;
    private ChapterAssuntoComentario comentarioPai;
    private LocalDateTime data;
    private Integer verificacao;
    private ChapterAssunto chapterAssunto;
    private String usuarioId;
    private String usuarioVerificacaoId;

}

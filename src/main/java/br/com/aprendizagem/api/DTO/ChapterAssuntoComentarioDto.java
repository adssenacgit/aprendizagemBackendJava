package br.com.aprendizagem.api.DTO;

import br.com.aprendizagem.api.entity.Curtida;
import br.com.aprendizagem.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterAssuntoComentarioDto {

    private Long id;
    private String texto;
    private LocalDateTime data;
    private Long paiId;
    private Integer chapterAssuntoId;
    private String usuarioId;
    private Usuario usuario;
    private Set<Curtida> curtidas;
}

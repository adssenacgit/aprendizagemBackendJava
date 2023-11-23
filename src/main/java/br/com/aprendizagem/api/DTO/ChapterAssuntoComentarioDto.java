package br.com.aprendizagem.api.DTO;

import br.com.aprendizagem.api.entity.ChapterAssunto;
import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
import br.com.aprendizagem.api.entity.Curtida;
import br.com.aprendizagem.api.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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

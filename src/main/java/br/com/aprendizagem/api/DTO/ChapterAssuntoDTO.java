package br.com.aprendizagem.api.DTO;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterAssuntoDTO {

    private Integer id;

    private LocalDateTime dataCadastro;
    private String titulo;

    private String descricao;

    private byte[] imagem;

    private Long contadorVisualizacao;

    private Integer status;

    private Integer verificacao;

    private Chapter chapter;

    private Usuario usuario;

    private Usuario usuarioVerificacao;

    private Set<ChapterTag> tags = new HashSet<>();

    private Integer totalComentarios;
}

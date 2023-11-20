package br.com.aprendizagem.api.DTO;

import br.com.aprendizagem.api.entity.Chapter;
import br.com.aprendizagem.api.entity.ChapterAssuntoComentario;
import br.com.aprendizagem.api.entity.ChapterTag;
import br.com.aprendizagem.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterAssuntoComentariosPaiDto {

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

    private List<ChapterAssuntoComentario> comentariosPais;
}

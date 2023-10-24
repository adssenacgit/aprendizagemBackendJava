package br.com.aprendizagem.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ChapterAssunto {
    @Id
    @Column(name = "chapter_assunto_id")
    private Integer id;

    @Column(name = "chapter_assunto_data_cadastro")
    private LocalDateTime dataCadastro;
    @Lob
    @Column(name = "chapter_assunto_titulo", columnDefinition = "TEXT")
    private String titulo;

    @Lob
    @Column(name = "chapter_assunto_descricao", columnDefinition = "TEXT")
    private String descricao;

    @Lob
    @Column(name = "chapter_assunto_imagem", columnDefinition = "LONGBLOB")
    private byte[] imagem;

    @Column(name = "chapter_assunto_contador_visualizacao")
    private Long contadorVisualizacao;

    @Column(name = "chapter_assunto_status")
    private Integer status;

    @Column(name = "chapter_assunto_verificacao")
    private Integer verificacao;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "usuario_id_verificacao")
    private Usuario usuarioVerificacao;


}
//chapter_assunto_id
//chapter_assunto_data_cadastro
//chapter_assunto_titulo
//chapter_assunto_descricao
//chapter_assunto_imagem
//chapter_assunto_contador_visualizacao
//chapter_assunto_status
//chapter_assunto_verificacao
//chapter_id
//usuario_id
//usuario_id_verificacao

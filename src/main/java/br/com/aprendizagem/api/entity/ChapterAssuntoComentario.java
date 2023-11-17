package br.com.aprendizagem.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter_assunto_comentario")
public class ChapterAssuntoComentario {
    @Id
    @Column(name = "chapter_assunto_comentario_id")
    private Long id;
    @Lob
    @Column(name = "chapter_assunto_comentario_texto", columnDefinition = "TEXT")
    private String texto;
    @Column(name = "chapter_assunto_comentario_pai")
    private Long pai;
    @Column(name = "chapter_assunto_comentario_data")
    private LocalDateTime data;
    @Column(name = "chapter_assunto_comentario_verificacao")
    private Integer verificacao;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "chapter_assunto_id")
    private ChapterAssunto chapterAssunto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "usuario_id_verificacao")
    private Usuario usuarioVerificacao;

}
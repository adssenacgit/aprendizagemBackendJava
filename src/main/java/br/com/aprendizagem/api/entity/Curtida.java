package br.com.aprendizagem.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curtida_id")
    private Integer id;

    @Column(name = "curtida_rank")
    private Integer rank;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "chapter_assunto_comentario_id")
    private ChapterAssuntoComentario chapterAssuntoComentario;

}

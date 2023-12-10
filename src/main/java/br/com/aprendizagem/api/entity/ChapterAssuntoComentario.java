package br.com.aprendizagem.api.entity;

import br.com.aprendizagem.api.DTO.ChapterAssuntoComentarioDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chapter_assunto_comentario")
public class ChapterAssuntoComentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_assunto_comentario_id")
    private Long id;
    @Lob
    @Column(name = "chapter_assunto_comentario_texto", columnDefinition = "TEXT")
    private String texto;
    @ManyToOne
    @JoinColumn(name = "chapter_assunto_comentario_pai")
    private ChapterAssuntoComentario comentarioPai;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "chapterAssuntoComentario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Curtida> curtidas = new HashSet<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterAssuntoComentario that = (ChapterAssuntoComentario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
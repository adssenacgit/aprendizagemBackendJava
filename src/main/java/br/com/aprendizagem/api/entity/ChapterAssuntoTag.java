package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chapter_assunto_tag")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChapterAssuntoTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_assunto_tag_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "chapter_assunto_id")
    private ChapterAssunto chapterAssunto;

    @ManyToOne
    @JoinColumn(name = "chapter_tag_id")
    private ChapterTag chapterTag;

}

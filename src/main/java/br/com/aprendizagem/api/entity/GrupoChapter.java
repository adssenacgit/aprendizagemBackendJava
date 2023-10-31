package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "grupo_chapter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "grupo_chapter_id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "grupo_id")
    private Grupo grupo;
    @ManyToOne
    @JoinColumn (name = "chapter_id")
    private Chapter chapter;
}

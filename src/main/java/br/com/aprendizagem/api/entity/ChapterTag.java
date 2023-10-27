package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "chapter_tag")
public class ChapterTag {

    @Id
    @Column(name = "chapter_tag_id")
    private Long id;

    @Column(name = "chapter_tag_descricao")
    private String descricao;

    @Column(name = "chapter_tag_status")
    private Integer status = 1;
}
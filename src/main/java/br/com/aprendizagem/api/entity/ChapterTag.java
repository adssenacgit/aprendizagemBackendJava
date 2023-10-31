package br.com.aprendizagem.api.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "chapter_tag")
public class ChapterTag {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "chapter_tag_id")
    private Long id;

    @Getter
    @Column(name = "chapter_tag_descricao", unique = true)
    private String descricao;

    @Getter
    @Column(name = "chapter_tag_status")
    private Integer status;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
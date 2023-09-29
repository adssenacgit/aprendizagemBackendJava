package br.com.aprendizagem.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Chapter {
    @Id
    @Column(name = "chapter_id")
    private Integer id;
    @Column(name = "chapter_nome")
    private String nome;
    @Lob
    @Column(name = "chapter_descricao", columnDefinition = "MEDIUMTEXT")
    private String descricao;
    @Column(name = "chapter_status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
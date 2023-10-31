package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "chapter")
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
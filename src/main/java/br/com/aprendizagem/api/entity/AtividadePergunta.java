package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atividade_pergunta")
public class AtividadePergunta {
    @Id
    @Column(name = "atividade_pergunta_id")
    private Long id;

    @Lob
    @Column(name = "atividade_pergunta_descricao", columnDefinition = "text")
    private String descricao;

    @Column(name = "atividade_pergunta_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;
}
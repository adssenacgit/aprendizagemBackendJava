package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atividade_pergunta_recurso")
public class AtividadePerguntaRecurso {
    @Id
    @Column(name = "atividade_pergunta_recurso_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "atividade_pergunta_id")
    private AtividadePergunta atividadePergunta;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private Recurso recurso;
}
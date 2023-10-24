package br.com.aprendizagem.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "situacao_aprendizagem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoAprendizagem {

    @Id
    @Column(name = "situacao_aprendizagem_id")
    private Long id;

    @Column(name = "situacao_aprendizagem_titulo")
    private String titulo;

    @Lob
    @Column(name = "situacao_aprendizagem_descricao", columnDefinition = "longtext")
    private String descricao;

    @Column(name = "situacao_aprendizagem_ordem")
    private Integer ordem;

    @Column(name = "situacao_aprendizagem_inicio")
    private LocalDateTime inicio;

    @Column(name = "situacao_aprendizagem_fim")
    private LocalDateTime fim;

    @Column(name = "situacao_aprendizagem_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "planejamento_uc_id")
    private PlanejamentoUc planejamentoUc;

    @ManyToOne
    @JoinColumn(name = "grau_dificuldade_id")
    private GrauDificuldade grauDificuldade;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

}



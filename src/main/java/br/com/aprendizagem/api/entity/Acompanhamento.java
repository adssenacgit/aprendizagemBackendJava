package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "acompanhamento")
public class Acompanhamento {

    @Id
    @Column(name = "acompanhamento_id")
    private Long id;

    @Column(name = "acompanhamento_entrega")
    private String entrega;

    @Lob
    @Column(name = "acompanhamento_entrega_arquivo", columnDefinition = "longblob")
    private Blob entregaArquivo;

    @Column(name = "acompanhamento_inicio")
    private LocalDateTime inicio;

    @Column(name = "acompanhamento_finalizacao")
    private LocalDateTime finalizacao;

    @Column(name = "acompanhamento_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "avaliacao_conceito_id")
    private AvaliacaoConceito avaliacaoConceito;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "objeto_aprendizagem_id")
    private ObjetoAprendizagem objetoAprendizagem;

    @ManyToOne
    @JoinColumn(name = "situacao_aprendizagem_id")
    private SituacaoAprendizagem situacaoAprendizagem;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @Column(name = "acompanhamento_data_badge")
    private LocalDateTime dataBadge;

    @ManyToOne
    @JoinColumn(name = "atividade_pergunta_resposta_id")
    private AtividadePerguntaResposta atividadePerguntaResposta;

}



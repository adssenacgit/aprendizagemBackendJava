package br.com.aprendizagem.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private byte[] entregaArquivo;

    @Column(name = "acompanhamento_inicio")
    private LocalDateTime inicio;

    @Column(name = "acompanhamento_finalizacao")
    private LocalDateTime finalizacao;

    @Column(name = "acompanhamento_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    @Column(name = "avaliacao_conceito_id")
    private Integer avaliacaoConceitoId;

    @Column(name = "atividade_id")
    private Long atividadeId;

    @Column(name = "objeto_aprendizagem_id")
    private Long objetoAprendizagemId;

    @Column(name = "situacao_aprendizagem_id")
    private Long situacaoAprendizagemId;

    @Column(name = "badge_id")
    private Integer badgeId;

    @Column(name = "acompanhamento_data_badge")
    private LocalDateTime dataBadge;

    @Column(name = "atividade_pergunta_resposta_id")
    private Long atividadePerguntaRespostaId;

}



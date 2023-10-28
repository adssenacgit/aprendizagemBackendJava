package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "situacao_objeto_aprendizagem")
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoObjetoAprendizagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "situacao_objeto_aprendizagem_id")
    private Long id;

    @Column(name = "situacao_objeto_aprendizagem_ordem")
    private Integer ordem;

    @ManyToOne
    @JoinColumn(name = "situacao_aprendizagem_id")
    private SituacaoAprendizagem situacaoAprendizagem;

    @ManyToOne
    @JoinColumn(name = "objeto_aprendizagem_id")
    private ObjetoAprendizagem objetoAprendizagem;

}

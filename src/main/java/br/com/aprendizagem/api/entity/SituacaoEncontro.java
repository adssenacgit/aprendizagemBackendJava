package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "situacao_encontro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoEncontro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "situacao_encontro_id")
    private Integer id;

    @Column (name = "situacao_encontro_status")
    private Integer status;

    @ManyToOne
    @JoinColumn (name = "situacao_aprendizagem_id")
    private SituacaoAprendizagem situacaoAprendizagem;

    @ManyToOne
    @JoinColumn (name = "encontro_id")
    private Encontro encontro;
}

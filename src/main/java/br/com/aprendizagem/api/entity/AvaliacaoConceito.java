package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "avaliacao_conceito")
public class AvaliacaoConceito {
    @Id
    @Column(name = "avaliacao_conceito_id")
    private Integer id;

    @Column(name = "avaliacao_conceito_descricao")
    private String descricao;

    @Column(name = "avaliacao_conceito_valor_min")
    private Integer valorMin;

    @Column(name = "avaliacao_conceito_valor_max")
    private Integer valorMax;

    @Column(name = "avaliacao_conceito_status")
    private Integer status;
}
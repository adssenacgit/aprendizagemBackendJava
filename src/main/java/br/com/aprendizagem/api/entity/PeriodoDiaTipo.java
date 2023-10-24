package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "periodo_dia_tipo")
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoDiaTipo {
    @Id
    @Column(name = "periodo_dia_tipo_id")
    private Integer id;

    @Column(name = "periodo_dia_tipo_descricao")
    private String descricao;

    @Column(name = "periodo_dia_tipo_cor")
    private String cor;

    @Column(name = "periodo_dia_tipo_status")
    private Integer status;
}

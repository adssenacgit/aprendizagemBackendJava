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
@Table(name = "atividade_tipo")
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeTipo {

    @Id
    @Column(name = "atividade_tipo_id")
    private Integer id;

    @Column(name = "atividade_tipo_descricao")
    private String descricao;

    @Column(name = "atividade_tipo_status")
    private Integer status;

}

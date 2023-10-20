package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grau_dificuldade")
@AllArgsConstructor
@NoArgsConstructor
public class GrauDificuldade {

    @Id
    @Column(name = "grau_dificuldade_id")
    private Integer id;

    @Column(name = "grau_dificuldade_descricao")
    private String descricao;

    @Column(name = "grau_dificuldade_status")
    private Integer status;


}

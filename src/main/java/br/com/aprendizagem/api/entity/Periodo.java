package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "periodo")
public class Periodo {
    @Id
    @Column(name = "periodo_id")
    private Long id;
    @Column(name = "periodo_nome")
    private String nome;
    @Column(name = "periodo_status")
    private Integer status;
}

package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "badge_nivel")
public class BadgeNivel {
    @Id
    @Column(name = "badge_nivel_id")
    private Integer id;

    @Column(name = "badge_nivel_descricao")
    private String descricao;

    @Column(name = "badge_nivel_status")
    private Integer status;

}

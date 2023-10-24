package br.com.aprendizagem.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planejamento_uc")
public class PlanejamentoUc {

    @Id
    @Column(name = "planejamento_uc_id")
    private Long id;

    @Column(name = "planejamento_uc_descricao")
    private String descricao;

    @Column(name = "planejamento_uc_data_aprovacao")
    private LocalDateTime dataAprovacao;

    @Column(name = "planejamento_uc_status")
    private Integer status;
}

package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "controle_execucao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleExecucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "controle_execucao_id")
    private Long id;
    @Column(name = "controle_execucao_data")
    private LocalDateTime data;
    @Column(name = "controle_execucao_status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "registro_encontro_tipo_id")
    private EncontroTipo encontroTipo;
    @ManyToOne
    @JoinColumn(name = "encontro_id")
    private Encontro encontro;
    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;
}

//
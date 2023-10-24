package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "dia_letivo")
@AllArgsConstructor
@NoArgsConstructor
public class DiaLetivo {

    @Id
    @Column(name = "dia_letivo_id")
    private Long id;

    @Column(name = "dia_letivo")
    private LocalDateTime diaLetivo;

    @Column(name = "dia_letivo_dia")
    private Integer diaLetivoDia;

    @Column(name = "dia_letivo_mes")
    private Integer diaLetivoMes;

    @Column(name = "dia_letivo_ano")
    private Integer diaLetivoAno;

    @Column(name = "dia_letivo_semana")
    private Integer diaLetivoSemana;

    @Column(name = "dia_letivo_status")
    private Integer diaLetivoStatus;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "periodo_dia_tipo_id")
    private PeriodoDiaTipo periodoDiaTipo;
}

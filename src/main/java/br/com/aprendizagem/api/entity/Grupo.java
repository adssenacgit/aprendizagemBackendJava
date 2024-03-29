package br.com.aprendizagem.api.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "grupo")
@Entity
public class Grupo {
    @Id
    @Column(name = "grupo_id")
    private Long id;
    @Column(name = "grupo_descricao")
    private String descricao;
    @Column(name = "grupo_inicio")
    private LocalDateTime dataInicio;
    @Column(name = "grupo_fim")
    private LocalDateTime dataFim;
    @Column(name = "grupo_status")
    private Integer status;
    @Column(name = "turno_id")
    private Integer turnoId;
    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id")
    private UnidadeCurricular unidadeCurricular;
    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn (name = "professor_id")
    private Professor professor;

//    @ManyToMany(mappedBy = "grupos", fetch = FetchType.EAGER)
//    private Set<Estudante> estudantes = new HashSet<>();
}

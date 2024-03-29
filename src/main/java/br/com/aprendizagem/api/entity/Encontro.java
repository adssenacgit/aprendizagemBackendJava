package br.com.aprendizagem.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Encontro {
    @Id
    @Column(name = "encontro_id")
    private Long id;

    @Column(name = "encontro_observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "dia_letivo_id")
    private DiaLetivo diaLetivo;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Column(name = "encontro_hora_inicio")
    private LocalDateTime horaInicio;

    @Column(name = "encontro_hora_fim")
    private LocalDateTime horaFim;

    @Column( name = "encontro_local")
    private String local;

    @Column( name = "encontro_status")
    private Integer status;

    @ManyToOne
    @JoinColumn( name = "encontro_tipo_id")
    private EncontroTipo encontroTipo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinTable(name = "situacao_encontro",
            joinColumns = @JoinColumn(name = "encontro_id"),
            inverseJoinColumns = @JoinColumn(name = "situacao_aprendizagem_id"))
    private List<SituacaoAprendizagem> situacoesAprendizagem;

}

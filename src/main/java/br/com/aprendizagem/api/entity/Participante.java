package br.com.aprendizagem.api.entity;

import br.com.aprendizagem.api.response.GrupoResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participante")
public class Participante {
    @Id
    @Column(name = "participante_id")
    private Long id;
    @Column(name = "participante_data_matricula")
    private LocalDateTime dataMatricula;
    @Column(name = "participante_status")
    private Integer status;


    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;


    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @Column(name = "participante_permissao")
    private Integer permissao;
}

//participante_id
//participante_data_matricula
//participante_status
//grupo_id
//estudante_id
//participante_permissao
package br.com.aprendizagem.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "objeto_aprendizagem")
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoAprendizagem {

    @Id
    @Column(name = "objeto_aprendizagem_id")
    private Long id;

    @Column(name = "objeto_aprendizagem_titulo")
    private String titulo;

    @Column(name = "objeto_aprendizagem_descricao", columnDefinition = "longtext")
    private String descricao;

    @JsonIgnore
    @Lob
    @Column(name = "objeto_aprendizagem_arquivo", columnDefinition = "longblob")
    private byte[] arquivo;

    @Column(name = "objeto_aprendizagem_ordem")
    private Integer ordem;

    @Column(name = "objeto_aprendizagem_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name ="grau_dificuldade_id")
    private GrauDificuldade grauDificuldade;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "objeto_aprendizagem_recurso",
            joinColumns = @JoinColumn(name = "objeto_aprendizagem_id"),
            inverseJoinColumns = @JoinColumn(name = "recurso_id")
    )
    private List<Recurso> recursos = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name ="usuario_id")
//    private Usuario usuario;

//    @JsonBackReference
//    @ManyToMany(mappedBy = "objetosAprendizagem", fetch = FetchType.LAZY)
//    private List<SituacaoAprendizagem> situacoesAprendizagem;
}

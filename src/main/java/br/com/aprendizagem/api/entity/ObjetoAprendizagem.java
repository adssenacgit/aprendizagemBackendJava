package br.com.aprendizagem.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name ="usuario_id")
    private Usuario usuario;

//    @JsonBackReference
//    @ManyToMany(mappedBy = "objetosAprendizagem", fetch = FetchType.LAZY)
//    private List<SituacaoAprendizagem> situacoesAprendizagem;
}

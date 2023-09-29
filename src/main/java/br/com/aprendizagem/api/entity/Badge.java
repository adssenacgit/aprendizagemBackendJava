package br.com.aprendizagem.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "badge")
@Entity
public class Badge {
    @Id
    @Column(name = "badge_id")
    private Integer id;
    @Column(name = "badge_descricao")
    private String descricao;

    @JsonIgnore
    @Lob
    @Column(name = "badge_imagem", columnDefinition = "BLOB")
    private byte[] imagem;

    @Column(name = "badge_nome_arquivo")
    private String nomeArquivo;
    @Column(name = "badge_status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "badge_nivel_id")
    private BadgeNivel badgeNivel;

    @ManyToOne
    @JoinColumn(name = "badge_tipo_id")
    private BadgeTipo badgeTipo;
}

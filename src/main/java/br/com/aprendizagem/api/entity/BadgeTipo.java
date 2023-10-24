package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "badge_tipo")
public class BadgeTipo {
    @Id
    @Column(name = "badge_tipo_id")
    private Integer id;
    @Column(name = "badge_tipo_nome")
    private String nome;
    @Column(name = "badge_tipo_status")
    private Integer status;

//    @OneToMany (mappedBy = "badgeTipo", fetch = FetchType.LAZY)
//    private List<Badge> badges;
}

package br.com.aprendizagem.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "chapter_assunto")
public class ChapterAssunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_assunto_id")
    private Integer id;

    @Column(name = "chapter_assunto_data_cadastro")
    private LocalDateTime dataCadastro;
    @Lob
    @Column(name = "chapter_assunto_titulo", columnDefinition = "TEXT")
    private String titulo;

    @Lob
    @Column(name = "chapter_assunto_descricao", columnDefinition = "TEXT")
    private String descricao;

    @Lob
    @Column(name = "chapter_assunto_imagem", columnDefinition = "LONGBLOB")
    private byte[] imagem;

    @Column(name = "chapter_assunto_contador_visualizacao")
    private Long contadorVisualizacao;

    @Column(name = "chapter_assunto_status")
    private Integer status;

    @Column(name = "chapter_assunto_verificacao")
    private Integer verificacao;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "usuario_id_verificacao")
    private Usuario usuarioVerificacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "chapter_assunto_tag",
            joinColumns = @JoinColumn(name = "chapter_assunto_id"),
            inverseJoinColumns = @JoinColumn(name = "chapter_tag_id"))
    private Set<ChapterTag> tags = new HashSet<>();


}

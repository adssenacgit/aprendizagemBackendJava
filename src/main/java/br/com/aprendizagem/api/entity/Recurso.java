package br.com.aprendizagem.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Recurso {
    @Id
    @Column(name = "recurso_id")
    private Long id;

    @Column(name = "recurso_descricao")
    private String descricao;

    @Column(name = "recurso_nome_arquivo")
    private String nomeArquivo;

    @Lob
    @Column(name = "recurso_arquivo")
    private byte[] arquivo;

    @Column(name = "recurso_mime_type")
    private String mimeType;

    @Column(name = "recurso_data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "recurso_status")
    private Integer status;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

}
//recurso_id
//recurso_descricao
//recurso_nome_arquivo
//recurso_arquivo
//recurso_data_cadastro
//recurso_status
//usuario_id
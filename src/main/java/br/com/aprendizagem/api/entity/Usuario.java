package br.com.aprendizagem.api.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "usuario_cpf", nullable = false)
	private String cpf;
	@Column(name = "usuario_nome_completo", nullable = false)
	private String nomeCompleto;
	@Column(name = "usuario_apelido", nullable = false)	
	private String apelido;
	@Column(name = "usuario_email", nullable = false)	
	private String email;
	@Column(name = "usuario_data_nascimento", nullable = false)
	private LocalDateTime dataNascimento;
	@Column(name = "usuario_telefone", nullable = false)
	private String telefone;
	@Column(name = "usuario_data_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	@Column(columnDefinition = "LONGBLOB", name = "usuario_foto")
	private byte[] foto;
	@Column(name = "usuario_status", nullable = false)
	private Integer status;
	
	
//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	private Set<Estudante> estudantes = new HashSet<>();
    
//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	private Set<SenacCoin> senacCoin = new HashSet<>();
    
//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//	private Set<SenacCoinMovimentacao> senacCoinMovimentacao = new HashSet<>();
    
    //@OneToMany(mappedBy = "usuario")
    //private Set<Recurso> recursos = new HashSet<>();
}

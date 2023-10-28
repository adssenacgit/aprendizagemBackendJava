package br.com.aprendizagem.api.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "estudante")
public class Estudante {
	@Id
	@Column(name = "estudante_id", nullable = false)
	private Long id;
	@Column(name = "estudante_data_cadastro", nullable = false)
	private LocalDateTime dataCadastro;	
	@Column(name = "estudante_data_trancamento")
	private LocalDateTime dataTrancamento;
	@Column(name = "estudante_data_formatura")
	private LocalDateTime dataFormatura;
	@Column(name = "estudante_status", nullable = false)
	private Integer status;	

	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
    @JoinColumn(name = "oferta_id")
	private Oferta oferta;


    //@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	//private Set<EstudanteScore> scores = new HashSet<>();

//    @ManyToMany(fetch = FetchType.LAZY)
//	@JsonBackReference
//	@JoinTable(
//			name = "participante",
//			joinColumns = @JoinColumn(name = "estudante_id"),
//			inverseJoinColumns = @JoinColumn(name = "grupo_id")
//	)
//	private List<Grupo> grupos;
}

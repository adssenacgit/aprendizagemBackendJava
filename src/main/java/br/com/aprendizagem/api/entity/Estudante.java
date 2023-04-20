package br.com.aprendizagem.api.entity;

import java.time.LocalDate;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.aprendizagem.api.entity.Oferta;
import br.com.aprendizagem.api.entity.Usuario;
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
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estudante_id", nullable = false)
	private Long id;
	@Column(name = "estudante_data_cadastro", nullable = false)
	private LocalDateTime dataCadastro;	
	@Column(name = "estudante_data_trancamento", nullable = false)
	private LocalDateTime dataTrancamento;
	@Column(name = "estudante_data_formatura", nullable = false)
	private LocalDateTime dataFormatura;
	@Column(name = "estudante_status", nullable = false)
	private Integer status;	

	@ManyToOne
    @JoinColumn(name = "oferta_id", nullable = false)
	@JsonIgnore
	private Oferta oferta;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
	@JsonIgnore
	private Usuario usuario;
	
    //@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	//private Set<EstudanteScore> scores = new HashSet<>();
    
    //@OneToMany(mappedBy = "estudante")
    //private Set<Participante> participantes;
}

package br.com.aprendizagem.api.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "oferta")
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oferta_id", nullable = false)
    private Long id;
	
	@Column(name = "oferta_descricao", nullable = false)
	private String descricao;
	
	@Column(name = "oferta_codigo", nullable = false)
	private String codigo;	

	@Column(name = "oferta_inicio_operacao", nullable = false)
	private LocalDateTime inicioOperacao;

	@Column(name = "oferta_status", nullable = false)
	private Integer status;	
	
	@ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
	@JsonIgnore
	private Curso curso;	
	
//	@OneToMany(mappedBy = "oferta")
//    private Set<Modulo> modulo;
}

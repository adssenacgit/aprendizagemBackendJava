package br.com.aprendizagem.api.entity;

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
@Table(name = "curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id", nullable = false)
    private Long id;
	
	@Column(columnDefinition = "VARCHAR", name = "curso_nome", nullable = false)
	private String nome;
	
	@Column(name = "curso_codigo", nullable = false)
	private String codigo;	

	@Column(name = "curso_horas", nullable = false)
	private Integer horas;

	@Column(name = "curso_status", nullable = false)
	private Integer status;	
	
	@ManyToOne
    @JoinColumn(name = "curso_tipo_id", nullable = false)
	@JsonIgnore
	private CursoTipo cursoTipo;	
	
	@OneToMany(mappedBy = "curso")
    private Set<Oferta> oferta;
}

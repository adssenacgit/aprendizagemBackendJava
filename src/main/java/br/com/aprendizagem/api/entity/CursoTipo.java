package br.com.aprendizagem.api.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "curso_tipo")
public class CursoTipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_tipo_id", nullable = false)
    private Integer id;
	
	@Column(name = "curso_tipo_descricao", nullable = false)
	private String descricao;
	
	@Column(name = "curso_tipo_status", nullable = false)
	private Integer status;
			
	@OneToMany(mappedBy = "cursoTipo")
    private Set<Curso> cursos;
}

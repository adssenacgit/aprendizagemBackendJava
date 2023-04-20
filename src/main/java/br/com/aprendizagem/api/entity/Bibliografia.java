package br.com.aprendizagem.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bibliografia")
public class Bibliografia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bibliografia_id", nullable = false)
    private Long id;
	
	@Column(name = "bibliografia_nome", nullable = false)
	private String nome;

	@Column(name = "bibliografia_status", nullable = false)
	private Integer status;	
	
	@ManyToOne
    @JoinColumn(name = "unidade_curricular_id", nullable = false)
	@JsonIgnore
	private UnidadeCurricular unidadeCurricular;	
	
}

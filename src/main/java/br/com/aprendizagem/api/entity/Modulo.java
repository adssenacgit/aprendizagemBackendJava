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

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "modulo")
public class Modulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "modulo_id", nullable = false)
    private Integer id;
	
	@Column(name = "modulo_descricao", nullable = false)
	private String descricao;
	
	@Column(name = "modulo_carga_horaria", nullable = false)
	private int cargaHoraria;	

	@ManyToOne
    @JoinColumn(name = "oferta_id", nullable = false)
	@JsonIgnore
	private Oferta oferta;	
	
	@OneToMany(mappedBy = "modulo")
    private Set<UnidadeCurricular> unidadeCurricular;
}

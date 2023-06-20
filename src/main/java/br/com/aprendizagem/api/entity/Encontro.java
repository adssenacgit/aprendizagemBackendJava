package br.com.aprendizagem.api.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Encontro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable =false)
	private Long id;
	@Column(name = "observaco", nullable = false)
	private String observacao;
	@Column(name = "hora_inicio", nullable = false)
	private Datetime HoraInicio;
	@Column(name = "hora_fim", nullable = false)	
	private Datetime HoraFim;
	@Column(name = "local", nullable = false)	
	private String Local;
	@Column(name = "status", nullable = false)
	private Long status;
	
	@ManyToOne
   @JoinColumn(name = "encontrotipo_id", nullable = false)
	@JsonIgnore
	private EncontroTipo encontroTipo;
	    
	@OneToMany(mappedBy = "encontro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Grupo> grupo = new HashSet<>();
	
	@OneToMany(mappedBy = "encontro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<SituacaoEncontro> situacaoEncontro = new HashSet<>()
		
	@OneToOne(mappedBy = "encontro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<ControleExecucao> situacaoEncontro = new HashSet<>()
		
	//A Notação OneToMany serve para mapear, dentro do schema de Banco dados, os relacionamentos das tabelas com as suas respectivas entidades.
	//@OneToMany(mappedBy = "usuario")
    //private Set<Recurso> recursos = new HashSet<>();
}

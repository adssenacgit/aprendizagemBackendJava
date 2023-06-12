package br.com.aprendizagem.api.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@OneToMany(mappedBy = "encontro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Encontro> encontros = new HashSet<>();
    
	@OneToMany(mappedBy = "encontro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Grupo> grupo = new HashSet<>();
	
	@OneToMany(mappedBy = "encontro", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<SituacaoEncontro> situacaoEncontro = new HashSet<>()
}

package br.com.aprendizagem.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Noticia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noticia_id", nullable = false)
	private Long id;
	@Column(name = "noticia_titulo", nullable = false)
	private String Titulo;	
	@Column(name = "noticia_descricao", nullable = false)
	private String Descricao;
	@Column(name = "noticia_data", nullable = false)
	private LocalDateTime data;
	@Column(name = "noticia_autor", nullable = false)
	private String autor;	

	@ManyToOne
    @JoinColumn(name = "estudante_id", nullable = false)
	@JsonIgnore
	private Estudante estudante;
	
	@ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
	@JsonIgnore
	private Professor professor;
	
    //@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	//private Set<EstudanteScore> scores = new HashSet<>();
    
    //@OneToMany(mappedBy = "estudante")
    //private Set<Participante> participantes;
}


package br.com.aprendizagem.api.entity;

import java.util.Set;

import javax.persistence.*;

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
@Table(name = "unidade_curricular")
public class UnidadeCurricular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unidade_curricular_id", nullable = false)
    private Long id;
	
	@Column(name = "unidade_curricular_codigo", nullable = false)
	private String codigo;

	@JsonIgnore
	@Lob
	@Column(name = "unidade_curricular_img", nullable = false)
	private byte[] img;

	@Column(name = "unidade_curricular_nome", nullable = false)
	private String nome;
		
	@Column(name = "unidade_curricular_nome_curto", nullable = false)
	private String nomeCurto;	
	
	@Column(name = "unidade_curricular_horas", nullable = false)
	private Integer horas;	
		
	@Column(name = "unidade_curricular_ordem", nullable = false)
	private Integer ordem;	
	
	@Column(name = "unidade_curricular_status", nullable = false)
	private Integer status;	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modulo_id", nullable = false)
	private Modulo modulo;
	
	//@OneToMany(mappedBy = "competencia")
    //private Set<Competencia> competencia;

//	@OneToMany(mappedBy = "unidadeCurricular")
//    private Set<Bibliografia> bibliografia;
}

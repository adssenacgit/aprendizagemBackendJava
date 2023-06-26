package br.com.aprendizagem.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class EncontroTipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "encontroTipo_id", nullable = false)
	private String id;
	@Column(name = "encontroTipo_descricao", nullable = false)
	private String descricao;
	@Column(name = "encontrotTipo_status", nullable = false)

			
	@OneToMany(mappedBy = "EncontroTipo")
  	  private Set<Encontro> encontros;

}


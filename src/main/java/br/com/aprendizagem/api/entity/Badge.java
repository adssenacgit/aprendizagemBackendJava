package br.com.aprendizagem.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "badge")
public class Badge{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "badge_id", nullable = false)
	private  Integer badgeId;
	@Column(name = "badge_descricao", nullable = false)
	private String badgeDescricao;
	@JsonIgnore
	@Lob
	@Type(type="org.hibernate.type.ImageType")
	@Column(name = "badge_imagem", nullable = false)
	private byte[]  badgeImagem;
	@Column(name = "badge_nome_arquivo", nullable = false)	
	private String  nomeArquivo;
	@Column(name = "badge_status", nullable = false)
	
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "badge_nivel_id", nullable = false)
	@JsonIgnore
	private BadgeNivel badgeNivel;
	
}

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "senac_coin")
public class SenacCoin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "senac_coin_id", nullable = false)
	private Long id;
	@Column(name = "senac_coin_saldo", nullable = false)
	private Long saldo;
	@Column(name = "senac_coin_status", nullable = false)
	private int status;
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	@JsonIgnore
	private Usuario usuario;
}
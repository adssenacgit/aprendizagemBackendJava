package br.com.aprendizagem.api.entity;

import java.util.Date;

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
@Table(name = "senac_coin_movimentacao")
public class SenacCoinMovimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "senac_coin_movimentacao_id", nullable = false)
	private Long id;
	@Column(name = "senac_coin_movimentacao_data", nullable = false)
	private Date data;
	@Column(name = "senac_coin_movimentacao_observacao", columnDefinition = "LONGTEXT", nullable = false)
	private String observacao;
	@Column(name = "senac_coin_movimentacao_valor", nullable = false)
	private Long valor;
	@Column(name = "senac_coin_movimentacao_status", nullable = false)
	private int status;
	@ManyToOne
	@JoinColumn(name = "senac_coin_id")
	@JsonIgnore
	private SenacCoin senacCoin;
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	@JsonIgnore
	private Usuario usuario;
}


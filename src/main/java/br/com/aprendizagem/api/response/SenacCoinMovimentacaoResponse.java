package br.com.aprendizagem.api.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.SenacCoinMovimentacao;
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
public class SenacCoinMovimentacaoResponse {
	private Long id;
	private Date data;
	private String observacao;
	private Long valor;
	private int status;
	
	public static SenacCoinMovimentacaoResponse of(SenacCoinMovimentacao senacCoinMovimentacao) {
		return SenacCoinMovimentacaoResponse.builder()
				.id(senacCoinMovimentacao.getId())
				.data(senacCoinMovimentacao.getData())
				.observacao(senacCoinMovimentacao.getObservacao())
				.valor(senacCoinMovimentacao.getValor())
				.build();
	}

	public static List<SenacCoinMovimentacaoResponse> of(List<SenacCoinMovimentacao> senacCoinMovimentacoes) {
		List<SenacCoinMovimentacaoResponse> senacCoinMovimentacaoResponses = new ArrayList<>();
		for (SenacCoinMovimentacao senacCoinMovimentacao : senacCoinMovimentacoes) {
			senacCoinMovimentacaoResponses.add(of(senacCoinMovimentacao));
		}
		return senacCoinMovimentacaoResponses;
	}	
	
	
	public static Page<SenacCoinMovimentacaoResponse> of(Page<SenacCoinMovimentacao> senacCoinMovimentacoes) {
		List<SenacCoinMovimentacaoResponse> senacCoinMovimentacaoResponses = new ArrayList<>();
		for (SenacCoinMovimentacao senacCoinMovimentacao : senacCoinMovimentacoes) {
			senacCoinMovimentacaoResponses.add(of(senacCoinMovimentacao));
		}
		return new PageImpl<SenacCoinMovimentacaoResponse>(
					senacCoinMovimentacaoResponses, 
					senacCoinMovimentacoes.getPageable(),
					senacCoinMovimentacoes.getTotalElements()
				);
	}
	
	
}
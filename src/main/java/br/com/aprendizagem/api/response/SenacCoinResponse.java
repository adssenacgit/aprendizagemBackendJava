package br.com.aprendizagem.api.response;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.SenacCoin;
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
public class SenacCoinResponse {
	private Long id;
	private Long saldo;
	private int status;
	
	public static SenacCoinResponse of(SenacCoin senacCoin) {
		return SenacCoinResponse.builder()
				.id(senacCoin.getId())
				.saldo(senacCoin.getSaldo())
				.status(senacCoin.getStatus())
				.build();
	}

	public static List<SenacCoinResponse> of(List<SenacCoin> senacCoins) {
		List<SenacCoinResponse> senacCoinResponses = new ArrayList<>();
		for (SenacCoin senacCoin : senacCoins) {
			senacCoinResponses.add(of(senacCoin));
		}
		return senacCoinResponses;
	}	
	
	
	public static Page<SenacCoinResponse> of(Page<SenacCoin> senacCoins) {
		List<SenacCoinResponse> senacCoinResponses = new ArrayList<>();
		for (SenacCoin senacCoin : senacCoins) {
			senacCoinResponses.add(of(senacCoin));
		}
		return new PageImpl<SenacCoinResponse>(
					senacCoinResponses, 
					senacCoins.getPageable(),
					senacCoins.getTotalElements()
				);
	}
	
	
}
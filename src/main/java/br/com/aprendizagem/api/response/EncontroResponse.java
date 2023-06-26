package br.com.aprendizagem.api.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.Encontro;
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
public class EncontroResponse {
	private Long id;
  private String observacao;
 	private Datetime HoraInicio;
	private Datetime HoraFim;
	private String Local;
 	private Long status;

	
	public static EncontroResponse of(Encontro encontro) {
		return EncontroResponse.builder()
				.id(encontro.getId())
				.cpf(encontro.getObservacao())
				.horaInicio(encontro.getHoraInicio())
				.horaFim(encontro.getHoraFim())
				.local(encontro.getLocal())
				.dataNascimento(encontro.getDataNascimento())
				.status(encontro.getStatus())
				.build();
	}

	public static List<EncontroResponse> of(List<Encontro> encontros) {
		List<EncontroResponse> encontroResponses = new ArrayList<>();
		for (Encontro encontro : encontros) {
			encontroResponses.add(of(encontro));
		}
		return encontroResponses;
	}	
	
	
	public static Page<EncontroResponse> of(Page<Encontro> encontros) {
		List<EncontroResponse> encontroResponses = new ArrayList<>();
		for (encontro encontro : encontros) {
			EncontroResponses.add(of(encontro));
		}
		return new PageImpl<encontroResponse>(
					EncontroResponses, 
					encontros.getPageable(),
					encontros.getTotalElements()
				);
	}
	
	
}

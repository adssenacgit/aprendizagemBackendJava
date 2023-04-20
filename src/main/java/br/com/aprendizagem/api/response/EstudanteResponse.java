package br.com.aprendizagem.api.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.Estudante;
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
public class EstudanteResponse {
	private Long id;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataTrancamento;
	private LocalDateTime dataDataFormatura;
	private Integer status;
	
	public static EstudanteResponse of(Estudante estudante) {
		return EstudanteResponse.builder()
				.id(estudante.getId())
				.dataCadastro(estudante.getDataCadastro())
				.dataTrancamento(estudante.getDataTrancamento())
				.dataDataFormatura(estudante.getDataFormatura())
				.status(estudante.getStatus())
				.build();
	}
	
	public static Page<EstudanteResponse> of(Page<Estudante> estudantes) {
		List<EstudanteResponse> estudanteResponses = new ArrayList<>();
		for (Estudante estudante : estudantes) {
			estudanteResponses.add(of(estudante));
		}
		return new PageImpl<EstudanteResponse>(
					estudanteResponses, 
					estudantes.getPageable(),
					estudantes.getTotalElements()
				);
	}
}

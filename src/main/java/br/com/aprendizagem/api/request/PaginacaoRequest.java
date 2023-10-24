package br.com.aprendizagem.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
public class PaginacaoRequest {
	private Integer pagina;
    private Integer itensPorPagina;
}

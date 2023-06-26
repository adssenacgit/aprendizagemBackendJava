package br.com.aprendizagem.api.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.Noticia;
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
public class NoticiaResponse {
	private String id;
	private String titulo;
	private String descricao;
	private String autor;
	private LocalDateTime dataPublicacao;
		
	public static NoticiaResponse of(Noticia noticia) {
		return NoticiaResponse.builder()
				.id(noticia.getId())
				.titulo(noticia.getTitulo())
				.descricao(noticia.getDescricao())
				.autor(noticia.getAutor())
				.dataPublicacao(noticia.getDataPublicacao())
				}

	public static List<NoticiaResponse> of(List<Noticia> noticias) {
		List<NoticiaResponse> noticiaResponses = new ArrayList<>();
		for (Noticia noticia : noticias) {
			noticiaResponses.add(of(noticia));
		}
		return noticiaResponses;
	}	
	
	
	public static Page<NoticiaResponse> of(Page<Noticia> noticias) {
		List<NoticiaResponse> noticiaResponses = new ArrayList<>();
		for (Noticia noticia : noticias) {
			noticiaResponses.add(of(noticia));
		}
		return new PageImpl<NoticiaResponse>(
					noticiaResponses, 
					noticias.getPageable(),
					noticias.getTotalElements()
				);
	}
	
	
}

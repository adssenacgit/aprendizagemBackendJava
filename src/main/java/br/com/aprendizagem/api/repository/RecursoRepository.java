package br.com.aprendizagem.api.repository;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.response.RecursoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    @Query("SELECT r from Recurso r WHERE r.status = 1")
    List<Recurso> getActiveRecursos();

    @Query("SELECT NEW br.com.aprendizagem.api.response.RecursoResponse(r.id, r.descricao, r.nomeArquivo, r.mimeType, r.dataCadastro, r.status, r.tamanho, r.usuario) from Recurso r WHERE r.status = 1")
    List<RecursoResponse> getActiveRecursosSemArquivo();

    @Query("SELECT NEW br.com.aprendizagem.api.response.RecursoResponse(r.id, r.descricao, r.nomeArquivo, r.mimeType, r.dataCadastro, r.status, r.tamanho, r.usuario) from Recurso r WHERE r.status != -1 AND r.usuario.id = :usuarioId")
    List<RecursoResponse> getActiveRecursosByUsuarioIdSemArquivo(
            @Param("usuarioId") String usuarioId
    );

    @Query("SELECT NEW br.com.aprendizagem.api.response.RecursoResponse(r.id, r.descricao, r.nomeArquivo, r.mimeType, r.dataCadastro, r.status, r.tamanho, r.usuario) from Recurso r WHERE r.status = 2")
    List<RecursoResponse> getPublicRecursosSemArquivo();
}
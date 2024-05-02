package bbddmysql.springboot.domain.repository;

import bbddmysql.springboot.domain.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;
@RepositoryRestResource(collectionResourceRel = "preguntas", path = "preguntas")
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

    @Query("SELECT p FROM Pregunta p WHERE p.tematica = :tematica")
    List<Pregunta> findByTematica(@Param("tematica") String tematica);




}

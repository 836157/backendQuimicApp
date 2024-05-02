package bbddmysql.springboot.domain.repository;


import bbddmysql.springboot.domain.entity.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "respuestas", path = "respuestas")
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {



}

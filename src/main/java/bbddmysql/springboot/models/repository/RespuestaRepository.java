package bbddmysql.springboot.models.repository;


import bbddmysql.springboot.models.entity.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;
@RepositoryRestResource(collectionResourceRel = "respuestas", path = "respuestas")
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {



}

package bbddmysql.springboot.domain.repository;

import bbddmysql.springboot.domain.entity.Reaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reacciones", path = "reacciones")
public interface ReaccionRepository extends JpaRepository<Reaccion,Integer> {




}

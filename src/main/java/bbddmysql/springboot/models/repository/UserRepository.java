package bbddmysql.springboot.models.repository;

import bbddmysql.springboot.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByCorreoAndPassword(String correo, String password);

    List<User> findByActivoTrue();
}

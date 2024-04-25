package bbddmysql.springboot.models.repository;

import bbddmysql.springboot.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByCorreoAndPassword(String correo, String password);

    Optional<User> findUserByCorreo(String correo);



    List<User> findByActivoTrue();
}

package bbddmysql.springboot.models.repository;

import bbddmysql.springboot.models.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "elemento", path = "elemento")
public interface ElementRepository extends JpaRepository<Element, Integer> {
    Element findByNombre(String nombre);

    Element findBySimbolo(String simbolo);

    Optional<Element> findByNombreIgnoreCaseOrSimbolo(String nombre, String simbolo);

    List<Element> findByDensidad(double densidad);
}

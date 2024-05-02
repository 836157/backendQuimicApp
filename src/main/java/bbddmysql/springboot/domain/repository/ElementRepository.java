package bbddmysql.springboot.domain.repository;

import bbddmysql.springboot.domain.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "elemento", path = "elemento")
public interface ElementRepository extends JpaRepository<Element, Integer> {
   // Element findByNombre(String nombre);

    //Element findBySimbolo(String simbolo);

    Optional<Element> findByNombreIgnoreCaseOrSimbolo(String nombre, String simbolo);

    //List<Element> findByDensidad(double densidad);

   // List<Element> findAll(String campo);


}




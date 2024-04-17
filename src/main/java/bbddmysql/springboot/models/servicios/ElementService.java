package bbddmysql.springboot.models.servicios;

import bbddmysql.springboot.models.entity.Element;
import bbddmysql.springboot.models.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ElementService {
    @Autowired
    private ElementRepository repositoryElement;

    public List<Element> getElements(){
        return repositoryElement.findAll();
    }

    public Optional<Element> getElementById(int id){
        return repositoryElement.findById(id);
    }

    public Optional<Element> buscarElementByNombreOrSimbol(String nombre, String simbolo){
        return repositoryElement.findByNombreIgnoreCaseOrSimbolo(nombre,simbolo);
    }


}

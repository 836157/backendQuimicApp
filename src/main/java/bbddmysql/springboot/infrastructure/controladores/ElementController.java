package bbddmysql.springboot.infrastructure.controladores;

import bbddmysql.springboot.domain.entity.Element;
import bbddmysql.springboot.infrastructure.servicios.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elemento")
public class ElementController {

    @Autowired
    private ElementService elementService;

    //lista todos los elementos quimicos. get all
    @GetMapping("/listar")
    public List<Element> listarElementosQuimicos() {
        return elementService.getElements();
    }

    //Recupera un elemento quimico por GET id
    @GetMapping("/{id}")
    public Optional<Element> buscarElementoQuimicoPorId(@PathVariable(value = "id") int id) {
        return elementService.getElementById(id);
    }

    // Buscar elemento por nombre
    @GetMapping("/busquedabynombreorsimbol")
    public ResponseEntity<Element> getElementByNombreOrSimbolo(@RequestParam String nombre, @RequestParam String simbolo) {
        Optional<Element> element = elementService.buscarElementByNombreOrSimbol(nombre, simbolo);
        return element.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}

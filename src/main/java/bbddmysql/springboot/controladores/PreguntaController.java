package bbddmysql.springboot.controladores;

import bbddmysql.springboot.models.entity.Pregunta;
import bbddmysql.springboot.models.servicios.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    private final PreguntaService preguntaService;

    @Autowired
    public PreguntaController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping("/tematica/{tematica}")
    public List<Pregunta> getPreguntasPorTematica(@PathVariable String tematica) {
        return preguntaService.getPreguntasPorTematica(tematica);
    }
}
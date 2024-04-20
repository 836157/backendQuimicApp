package bbddmysql.springboot.controladores;

import bbddmysql.springboot.models.entity.Pregunta;
import bbddmysql.springboot.models.entity.Respuesta;
import bbddmysql.springboot.models.servicios.PreguntaService;
import bbddmysql.springboot.models.servicios.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    private final PreguntaService preguntaService;
    private final RespuestaService respuestaService;

    @Autowired
    public PreguntaController(PreguntaService preguntaService, RespuestaService respuestaService) {
        this.preguntaService = preguntaService;
        this.respuestaService = respuestaService;
    }

    @GetMapping("/tematica/{tematica}")
    public List<Pregunta> getPreguntasPorTematica(@PathVariable String tematica) {
        return preguntaService.getPreguntasPorTematica(tematica);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta) {
        Pregunta nuevaPregunta = preguntaService.guardarPregunta(pregunta);

        int id_pregunta = nuevaPregunta.getId();
        System.out.println(id_pregunta);
        for (Respuesta respuesta : pregunta.getRespuestas()) {
            respuesta.setPreguntaid(id_pregunta);
            respuestaService.guardarRespuesta(respuesta); // Aquí es donde cambió el código
        }
        return new ResponseEntity<>(nuevaPregunta, HttpStatus.CREATED);
    }


}
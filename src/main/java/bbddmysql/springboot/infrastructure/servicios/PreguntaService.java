package bbddmysql.springboot.infrastructure.servicios;

import bbddmysql.springboot.domain.entity.Pregunta;
import bbddmysql.springboot.domain.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;

    @Autowired
    public PreguntaService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    public List<Pregunta> getPreguntasPorTematica(String tematica) {
        return preguntaRepository.findByTematica(tematica);
    }

    public Pregunta guardarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }


}
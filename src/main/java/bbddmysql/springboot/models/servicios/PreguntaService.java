package bbddmysql.springboot.models.servicios;

import bbddmysql.springboot.models.entity.Pregunta;
import bbddmysql.springboot.models.repository.PreguntaRepository;
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


}
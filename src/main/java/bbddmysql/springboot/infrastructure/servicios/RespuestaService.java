package bbddmysql.springboot.infrastructure.servicios;

import bbddmysql.springboot.domain.entity.Respuesta;
import bbddmysql.springboot.domain.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta guardarRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }
}
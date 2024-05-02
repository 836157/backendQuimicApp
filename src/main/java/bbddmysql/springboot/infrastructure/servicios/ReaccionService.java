package bbddmysql.springboot.infrastructure.servicios;

import bbddmysql.springboot.domain.entity.Reaccion;
import bbddmysql.springboot.domain.repository.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaccionService {
    @Autowired

    private ReaccionRepository reaccionRepository;

    public List<Reaccion> getReaccion() {
        return reaccionRepository.findAll();
    }

}

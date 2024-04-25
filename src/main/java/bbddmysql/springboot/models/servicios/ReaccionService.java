package bbddmysql.springboot.models.servicios;

import bbddmysql.springboot.models.entity.Reaccion;
import bbddmysql.springboot.models.repository.ReaccionRepository;
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

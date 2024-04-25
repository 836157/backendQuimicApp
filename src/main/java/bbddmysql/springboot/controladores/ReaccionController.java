package bbddmysql.springboot.controladores;

import bbddmysql.springboot.models.entity.Reaccion;
import bbddmysql.springboot.models.servicios.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reacciones")
public class ReaccionController {

    @Autowired
    private ReaccionService reaccionService;

    @GetMapping("/listar")
    public List<Reaccion> listar() {
        return reaccionService.getReaccion();
    }

}

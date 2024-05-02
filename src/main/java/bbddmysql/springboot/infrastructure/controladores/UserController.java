package bbddmysql.springboot.infrastructure.controladores;

import bbddmysql.springboot.domain.entity.User;
import bbddmysql.springboot.infrastructure.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/listarActivos")
    //lista todos los usuarios existentes
    public List<User> listarUsuariosActivos() {
        return userService.getActiveUsers();
    }

    //Recupera un usuario por GET id
    @GetMapping("/recupera/{id}")
    public ResponseEntity<User> buscarUsuarioPorId(@PathVariable(value = "id") int id) {
        Optional<User> usuario = userService.getUserById(id);
        return usuario.map(entidadUsuario -> ResponseEntity.ok().body(entidadUsuario)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //insertar usuarios POSTz
    @PostMapping("/save")
    public Boolean guardarUsuario(@Validated @RequestBody User usuario) {
        return userService.saveUser(usuario);
    }

    //borrar por id DELETE
    @DeleteMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable(value = "id") int id) {
        return userService.deleteUser(id);
    }

    //modificar
    @PutMapping("/mod")
    public ResponseEntity<?> actualizarUsuario(@RequestBody User usuarioMod) {
        Optional<User> usuario = userService.getUserById(usuarioMod.getId());
        if (usuario.isPresent()) {
            usuario.get().setNombre(usuarioMod.getNombre());
            usuario.get().setApellido(usuarioMod.getApellido());
            usuario.get().setCorreo(usuarioMod.getCorreo());
            usuario.get().setPassword(usuarioMod.getPassword());
            userService.saveUser(usuario.get());
            return ResponseEntity.ok().body("");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

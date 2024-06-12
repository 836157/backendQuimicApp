package bbddmysql.springboot.infrastructure.controladores;

import bbddmysql.springboot.domain.entity.User;
import bbddmysql.springboot.infrastructure.servicios.AESCipherService;
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

    @Autowired
    private AESCipherService aesCipherService;

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
        usuario.setPassword(aesCipherService.encrypt(usuario.getPassword()));
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
        usuarioMod.setPassword(aesCipherService.encrypt(usuarioMod.getPassword()));
        User updatedUser = userService.updateUser(usuarioMod);
        if (updatedUser != null) {
            return ResponseEntity.ok().body("Usuario actualizado correctaMENTE");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

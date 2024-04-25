package bbddmysql.springboot.models.servicios;

import bbddmysql.springboot.models.entity.User;
import bbddmysql.springboot.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repositoryUser;

    public List<User> getUsers() {
        return repositoryUser.findAll();
    }

    public List<User> getActiveUsers() {
        return repositoryUser.findByActivoTrue();
    }

    public Optional<User> getUserById(int id) {
        return repositoryUser.findById(id);
    }

    public boolean saveUser(User user) {
        Optional<User> usuario = repositoryUser.findUserByCorreo(user.getCorreo());
        if (usuario.isPresent()) {
            return false;
        } else {
            repositoryUser.save(user);
            return true;
        }
    }

    public String deleteUser(int id) {
        Optional<User> user = repositoryUser.findById(id);
        if (user.isPresent()) {
            repositoryUser.deleteById(id);
            return "Usuario con id " + id + " eliminado correctamente";
        } else {
            return "No existe un usuario con id " + id;
        }
    }

    public User updateUser(User user) {
        Optional<User> optionalUser = repositoryUser.findById(user.getId());
        if (optionalUser.isPresent()) {
            User existeUser = optionalUser.get();
            //Realizar la actualizacion del usuario
            existeUser.setNombre(user.getNombre());
            existeUser.setApellido(user.getApellido());
            existeUser.setCorreo(user.getCorreo());
            existeUser.setPassword(user.getPassword());
            return repositoryUser.save(existeUser);
        }
        return null;
    }

    public User login(String correo, String password) {
        return repositoryUser.findByCorreoAndPassword(correo, password);
    }

}

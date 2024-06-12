package bbddmysql.springboot.infrastructure.controladores;

import bbddmysql.springboot.domain.entity.User;
import bbddmysql.springboot.infrastructure.servicios.AESCipherService;
import bbddmysql.springboot.infrastructure.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AESCipherService aesCipherService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String,String> credentials){
        String correo = credentials.get("correo");
        String password = credentials.get("password");
        User user = userService.getUserByEmail(correo);
        if (user != null && password.equals(aesCipherService.decrypt(user.getPassword()))) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}

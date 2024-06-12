package bbddmysql.springboot.infrastructure.controladores;

import bbddmysql.springboot.domain.entity.EmailDTO;
import bbddmysql.springboot.domain.entity.User;
import bbddmysql.springboot.domain.repository.UserRepository;
import bbddmysql.springboot.infrastructure.servicios.AESCipherService;
import bbddmysql.springboot.infrastructure.servicios.IEmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/send-email")
public class EmailController {

    @Autowired
    IEmailService emailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ResourceLoader resourceLoader;


    @PostMapping("/sendUserEmail")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) throws MessagingException {
        emailService.sendEmail(emailDTO);
        return new ResponseEntity<>("Email enviado correctamente", org.springframework.http.HttpStatus.OK);
    }


    @PostMapping("/recuperarCorreo")
    private ResponseEntity<String> sendEmailRecuperarPassword(@RequestBody EmailDTO emailDTO) throws MessagingException {
        // Comprueba si el correo existe en la base de datos
        User usuario = userRepository.findUserByCorreo(emailDTO.getEmailRecipient()).orElse(null);
        if (usuario != null) {
            emailService.sendEmailRecuperarPassword(emailDTO);
            return new ResponseEntity<>("Email enviado correctamente", org.springframework.http.HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe usuario asociado al correo introducido", HttpStatus.NOT_FOUND);
    }

   @GetMapping("/newPasswordForm")
    public ResponseEntity<Resource> serveNewPasswordForm() {
        Resource resource = resourceLoader.getResource("classpath:templates/newPasswordForm.html");
        return ResponseEntity.ok(resource);
    }

   /* @GetMapping("/newPasswordForm")
    public String serveNewPasswordForm() {
        return "redirect:https://solecas864.ieszaidinvergeles.es/newPasswordForm.html";
    }*/

    @Autowired
    AESCipherService aesCipherService;

    @PostMapping("/newPassword")
    public ResponseEntity<String> resetPassword(@RequestParam String correo, @RequestParam String newPassword) {
        Optional<User> usuario = userRepository.findUserByCorreo(correo);
        if (usuario.isEmpty()) {
            return new ResponseEntity<>("No existe usuario asociado al correo introducido", HttpStatus.NOT_FOUND);
        }
        User user = usuario.get();
        String encryptedPassword = aesCipherService.encrypt(newPassword); // Cifrar la contraseña
        user.setPassword(encryptedPassword);
        userRepository.save(user);

        return new ResponseEntity<>("Contraseña actualizada correctamente", HttpStatus.OK);
    }

}

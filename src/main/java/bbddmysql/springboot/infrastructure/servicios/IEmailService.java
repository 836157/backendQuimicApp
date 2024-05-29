package bbddmysql.springboot.infrastructure.servicios;


import bbddmysql.springboot.domain.entity.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailService {

    void sendEmail(EmailDTO emailDTO) throws MessagingException;

    void sendEmailRecuperarPassword(EmailDTO emailDTO) throws MessagingException;
}

package bbddmysql.springboot.infrastructure.servicios;

import bbddmysql.springboot.domain.entity.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements IEmailService{

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;


    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(emailDTO.getEmailRecipient());
            helper.setSubject(emailDTO.getEmailSubject());

            Context context = new Context();
            context.setVariable("emailBody", emailDTO.getEmailBody());
            String html = templateEngine.process("email", context);
            helper.setText(html, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new MessagingException("Error al enviar el correo"+ e.getMessage());
        }

    }

    @Override
    public void sendEmailRecuperarPassword(EmailDTO emailDTO) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(emailDTO.getEmailRecipient());
            helper.setSubject(emailDTO.getEmailSubject());

            Context context = new Context();
            context.setVariable("emailBody", emailDTO.getEmailBody());

            String resetLink = "http://192.168.0.23:8080/quimicApp/send-email/newPasswordForm";
            context.setVariable("resetLink", resetLink);

            String html = templateEngine.process("emailRecuperacion", context);
            helper.setText(html, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new MessagingException("Error al enviar el correo de recuperacion"+ e.getMessage());
        }
    }
}

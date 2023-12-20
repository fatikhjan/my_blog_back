package uz.company.my_blog_back.service;


import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import uz.company.my_blog_back.domain.Mail;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;


@Service
public class MessageService {

    private final JavaMailSender javaMailSender;

    public MessageService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(String.valueOf(new InternetAddress(mail.getMailFrom())));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(mail.getMailContent() + " \n sender : " + mail.getMailFrom());
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}

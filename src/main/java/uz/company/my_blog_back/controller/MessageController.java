package uz.company.my_blog_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.company.my_blog_back.domain.Mail;
import uz.company.my_blog_back.dto.MessageDTO;
import uz.company.my_blog_back.service.MessageService;

@RestController
@RequiredArgsConstructor
public class MessageController {


    public final MessageService messageService;

    @PostMapping("api/sendMessage")
    public String sendMessage(@RequestBody MessageDTO message) {
        Mail mail = new Mail();
        mail.setMailFrom(message.getSender());
        mail.setMailTo("muhammad2004fotih@gmail.com");
        mail.setMailSubject("From Portfolio project");
        mail.setMailContent(message.getMessage());
        messageService.sendEmail(mail);
        return "ok";
    }

}

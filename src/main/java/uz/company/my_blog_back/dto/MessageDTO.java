package uz.company.my_blog_back.dto;

import lombok.Getter;

@Getter
public class MessageDTO {
    private String sender;
    private String message;
    private String time;
}

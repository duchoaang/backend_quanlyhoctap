package com.ndh.hotrohoctap.services;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Async
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
//        System.out.println("zo da");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        System.out.println(message);
        try{
            javaMailSender.send(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

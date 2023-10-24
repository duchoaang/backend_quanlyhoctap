package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sendmail")
@RequiredArgsConstructor
public class ApiSendMailController {
    public final EmailService emailService;
    @GetMapping("")
    public String sendEmail() {
        try {
            // Gửi email
            emailService.sendEmail("2051052047hoang@ou.edu.vn", "Chủ đề email", "Nội dung email");
            return "Email đã được gửi thành công.";
        } catch (Exception e) {
            return "Gửi email thất bại: " + e.getMessage();
        }

    }
}

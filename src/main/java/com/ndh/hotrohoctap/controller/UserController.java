package com.ndh.hotrohoctap.controller;


import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/admin/nguoidung")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping("")
    public String list(Model model){

        List<User> userList = userService.getAllUser();

        // Truyền danh sách người dùng vào mẫu Thymeleaf
        model.addAttribute("userList", userList);

        return "nguoidung";
    }
    @PutMapping("/disable-user/{userId}")
    public ResponseEntity<String> disableUser(@PathVariable Long userId) {
        userService.disableUser(userId);
        return ResponseEntity.ok("Người dùng đã được vô hiệu hóa.");
    }



}

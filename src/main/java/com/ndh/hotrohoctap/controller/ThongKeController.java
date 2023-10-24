package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/thongke")
public class ThongKeController {
    public final UserService userService;
    @GetMapping("")
    public String list(Model model){
        return "thongke";
    }
}

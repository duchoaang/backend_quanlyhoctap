package com.ndh.hotrohoctap.controller;


import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.services.DiemMonHocService;
import com.ndh.hotrohoctap.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trangchu")
@RequiredArgsConstructor
public class TrangChuController {

    public final UserService userService;
    private final DiemMonHocService diemMonHocService;
    @GetMapping("")
    public String list(Model model){
        List<DiemMonHoc> diemMonHocList = diemMonHocService.getAllDiemMonHoc();
        System.out.println("Diem nek" + diemMonHocList);
        model.addAttribute("diemMonHocList", diemMonHocList);


        return "trangchu";
    }



}

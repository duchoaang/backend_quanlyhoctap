package com.ndh.hotrohoctap.controller;


import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.dtos.QuanLyDiemMonHocDTO;
import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.services.DiemMonHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class QuanLyDiemController {
    public final DiemMonHocService diemMonHocService;
    @GetMapping("/quanlydiem")
    public String list(Model model) {
        List<DiemMonHoc> diemMonHocList = diemMonHocService.getAllDiemMonHoc();
        System.out.println("Diem nek" + diemMonHocList);
        model.addAttribute("diemMonHocList", diemMonHocList);
        return "quanlydiem";
    }

}

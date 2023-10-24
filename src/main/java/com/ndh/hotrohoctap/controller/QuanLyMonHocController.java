package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.MonHoc;
import com.ndh.hotrohoctap.services.MonHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/quanlymonhoc")
@RequiredArgsConstructor
public class QuanLyMonHocController {
    private final MonHocService monHocService;
    @GetMapping("")
    public String list(Model model){

        List<MonHoc> course = monHocService.getAllMonHoc();

        model.addAttribute("courseList", course);
        return "quanlymonhoc";
    }

    @PutMapping("/disable-monhoc/{monhocId}")
    public ResponseEntity<String> disableUser(@PathVariable Long monhocId) {
        monHocService.disableMonHoc(monhocId);
        return ResponseEntity.ok("Môn học đã được vô hiệu hóa.");
    }

}
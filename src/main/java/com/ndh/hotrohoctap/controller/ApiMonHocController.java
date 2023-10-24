package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.MonHoc;
import com.ndh.hotrohoctap.services.MonHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/monhoc")
@RequiredArgsConstructor
public class ApiMonHocController {
    private final MonHocService monHocService;
    @GetMapping("")
    public ResponseEntity<List<MonHoc>> getAllBaiTap() {
        List<MonHoc> listBaiTap = monHocService.getAllMonHoc();
        return ResponseEntity.ok(listBaiTap);
    }
    @PostMapping("")
    public String post() {
        return "post";
    }
}

package com.ndh.hotrohoctap.controller;


import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.MonHoc;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.services.BaiTapService;
import com.ndh.hotrohoctap.services.MonHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/quanlybaitap")
public class QuanLyBaiTapController {
    private final BaiTapService baiTapService;
    private final MonHocService monHocService;
    @GetMapping("")
    public String list(Model model){

        List<BaiTap> baiTaps = baiTapService.getAllBaiTap();

        model.addAttribute("baiTaps", baiTaps);
        List<MonHoc> monHocList = monHocService.getAllMonHoc();
        model.addAttribute("monHocList", monHocList);

        return "quanlybaitap";
    }
    @GetMapping("/searchBaiTap")
    public String searchBaiTap(@RequestParam String keyword, Model model) {
        List<BaiTap> baiTaps = baiTapService.searchBaiTap(keyword); // Triển khai phương thức searchBaiTap trong BaiTapService
        model.addAttribute("baiTaps", baiTaps);
        return "quanlybaitap"; // Trả về trang hiển thị kết quả
    }


}

package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.NopBaiDTO;
import com.ndh.hotrohoctap.dtos.UpdateBaiTapDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.services.BaiTapService;
import com.ndh.hotrohoctap.services.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/baiTap")
@RequiredArgsConstructor
public class ApiBaiTapController {
    private final BaiTapService baiTapService;
    private final EmailService emailService;
    @GetMapping("")
    public ResponseEntity<List<BaiTap>> getAllBaiTap() {
        List<BaiTap> listBaiTap = baiTapService.getAllBaiTap();
        return ResponseEntity.ok(listBaiTap);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getBaiTapById(@PathVariable Long id){
        BaiTap baiTap =  baiTapService.getBaiTapById(id);
        return ResponseEntity.ok("tim thay baiTap" + baiTap);

    }
    @PostMapping(value="")
    public ResponseEntity<?> insertBaiTap(@Valid @RequestBody BaiTapDTO baiTapDTO,
                                             BindingResult result) throws DataNotFoundException {
        System.out.println("123das");
        if(result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)

                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        System.out.println("helo");
        baiTapService.createBaiTap(baiTapDTO);
        return ResponseEntity.ok("Them moi bai tap thanh cong ");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBaiTap(@PathVariable Long id, @Valid @RequestBody UpdateBaiTapDTO updateBaiTapDTO){
        System.out.println("zo dc day r ");
        baiTapService.updateBaiTap(id,updateBaiTapDTO);
        return ResponseEntity.ok("update bai Tap thanh cong");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBaiTap(@PathVariable Long id){
        boolean temp = baiTapService.deleteBaiTap(id);
        System.out.println("vao toi day ");

        if(temp){
            return ResponseEntity.ok("Delete bai tap thanh cong");

        }
        else {
            System.out.println("vao toi day ");
            return ResponseEntity.badRequest().body("Delete bai tap k thanh cong");
        }
    }

    @GetMapping("/searchBaiTap")
    public String searchBaiTap(@RequestParam String keyword, Model model) {
        List<BaiTap> baiTaps = baiTapService.searchBaiTap(keyword); // Triển khai phương thức searchBaiTap trong BaiTapService
        model.addAttribute("baiTaps", baiTaps);
        return "quanlybaitap"; // Trả về trang hiển thị kết quả
    }


}

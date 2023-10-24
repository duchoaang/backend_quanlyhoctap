package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.DiemBaiTap;
import com.ndh.hotrohoctap.models.ThongBao;
import com.ndh.hotrohoctap.services.ThongBaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/thongbao")
@RequiredArgsConstructor
public class ApiThongBaoController {
    private final ThongBaoService thongBaoService;
    @GetMapping("")
    public ResponseEntity<List<ThongBao>> getAllThongBao() {
        List<ThongBao> thongBaos = thongBaoService.getALlThongBao();
        return ResponseEntity.ok(thongBaos);

    }
    @PostMapping(value="")
    public ResponseEntity<?> insertThongBao(@Valid @RequestBody ThongBao thongBao,
                                          BindingResult result) throws DataNotFoundException {
        if(result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)

                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        thongBaoService.createThongBao(thongBao);
        return ResponseEntity.ok("Them moi thong bao thanh cong ");
    }

}

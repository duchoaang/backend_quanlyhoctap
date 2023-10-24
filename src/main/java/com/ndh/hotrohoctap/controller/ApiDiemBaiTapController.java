package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemBaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.dtos.NopBaiDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.DiemBaiTap;
import com.ndh.hotrohoctap.services.BaiTapService;
import com.ndh.hotrohoctap.services.DiemBaiTapService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/diemBaiTap")
@RequiredArgsConstructor
public class ApiDiemBaiTapController {
    private final DiemBaiTapService diemBaiTapService;
    private final BaiTapService baiTapService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DiemMonHocDTO>> getDiemById(@PathVariable Long id) throws Exception {
        List<DiemBaiTap> diemBaiTaps = diemBaiTapService.getDiemBaiTapById(id);

        List<DiemMonHocDTO> diemMonHocDTOs = diemBaiTaps.stream()
                .map(diemMonHoc -> new DiemMonHocDTO(
                        diemMonHoc.getBaiTap().getTenBaiTap(),
                        diemMonHoc.getDiem(), diemMonHoc.getBaiTap().getMonHoc().getHocKi(), diemMonHoc.getThoiGian()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(diemMonHocDTOs);

    }
    @PostMapping("")
    public ResponseEntity<String> post(@Valid @RequestBody DiemBaiTapDTO diemBaiTapDTO,
                                       BindingResult result) throws DataNotFoundException {
        if(result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)

                    .toList();
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }
        diemBaiTapService.createDiemBaiTap(diemBaiTapDTO);
        return ResponseEntity.ok("Them moi bai tap thanh cong ");
    }


}

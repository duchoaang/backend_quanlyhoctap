package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemBaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.dtos.QuanLyDiemMonHocDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.services.DiemMonHocService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/diemMonHoc")
@RequiredArgsConstructor

public class ApiDiemMonHocController {
    private final DiemMonHocService diemMonHocService;


    @GetMapping("")
    public ResponseEntity<List<DiemMonHoc>> getAllBaiTap() {
        List<DiemMonHoc> listBaiTap = diemMonHocService.getAllDiemMonHoc();
        return ResponseEntity.ok(listBaiTap);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<DiemMonHocDTO>> getDiemById(@PathVariable Long id) throws Exception {
        List<DiemMonHoc> diemMonHocs = diemMonHocService.getDiemMonHocById(id);

        List<DiemMonHocDTO> diemMonHocDTOs = diemMonHocs.stream()
                .map(diemMonHoc -> new DiemMonHocDTO(
                        diemMonHoc.getMonHoc().getTenMonHoc(),
                        diemMonHoc.getDiem(),
                        diemMonHoc.getMonHoc().getHocKi(),
                        diemMonHoc.getThoiGian()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(diemMonHocDTOs);

    }

    @PostMapping(value="")
    public ResponseEntity<?> insertBaiTap(@Valid @RequestBody QuanLyDiemMonHocDTO quanLyDiemMonHocDTO,
                                          BindingResult result) throws DataNotFoundException {
        if(result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)

                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        diemMonHocService.createDiemMonHoc(quanLyDiemMonHocDTO);
        return ResponseEntity.ok("Them moi diem cho user thanh cong");
    }

    @GetMapping("/lessThan5")
    public ResponseEntity<List<DiemMonHoc>> findDiemMonHocBelow5() {
        List<DiemMonHoc> diemMonHocList = diemMonHocService.findDiemMonHocByDiemLessThan5();
        return ResponseEntity.ok(diemMonHocList);
    }
    @GetMapping("/greaterThan8")
    public ResponseEntity<List<DiemMonHoc>> findDiemMonHocByDiemGreaterThan8() {
        List<DiemMonHoc> diemMonHocList = diemMonHocService.findDiemMonHocByDiemGreaterThan8();
        return ResponseEntity.ok(diemMonHocList);
    }

}

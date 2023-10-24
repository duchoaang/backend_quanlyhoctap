package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.dtos.GiangVienDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/giangvien")
//@Validated
public class ApiGiangVienController {
    @GetMapping("")
    public ResponseEntity<String> getAllGiangVien(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok(String.format("getAllCategories, page = %d, limit = %d", page, limit));
    }
    @PostMapping("")
    public ResponseEntity<?> insertGiangVien(@Valid @RequestBody GiangVienDTO giangVienDTO,
                                                  BindingResult result){
        if(result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)

                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("Post mapping" + giangVienDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGiangVien(@PathVariable Long id){
        return ResponseEntity.ok("update ");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGiangVien(@PathVariable Long id){
        return ResponseEntity.ok("Delete");
    }


}

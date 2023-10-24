package com.ndh.hotrohoctap.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiangVienDTO {
    @NotEmpty(message = "Ten giang vien k duoc trong")
    private String tenGiangVien;
    
}

package com.ndh.hotrohoctap.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiemBaiTapDTO {
    @NotEmpty(message = "Ten bai tap 2 k duoc trong")
    private String idNguoiDung;
    @NotEmpty(message = "Noi dung k2  duoc null")
    private String idBaiTap;

}

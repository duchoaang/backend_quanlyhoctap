package com.ndh.hotrohoctap.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiTapDTO {
    @NotEmpty(message = "Ten bai tap k duoc trong")
    private String tenBaiTap;
    @NotEmpty(message = "Noi dung k duoc null")
    private String noiDung;
    @NotEmpty(message = "dap an k duoc null")
    private String dapAn;
    @NotEmpty(message = "mon hock duoc null")
    private String monHocId;
}

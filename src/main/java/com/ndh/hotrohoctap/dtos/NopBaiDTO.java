package com.ndh.hotrohoctap.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NopBaiDTO {
    @NotEmpty(message = "121231 bai tap k duoc trong")
    private String idBaiTap;
    @NotEmpty(message = "Noi dung k duoc null")
    private String idNguoiDung;}

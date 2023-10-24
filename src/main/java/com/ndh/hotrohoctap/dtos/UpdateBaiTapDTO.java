package com.ndh.hotrohoctap.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBaiTapDTO {
    @NotEmpty(message = "Ten bai tap k duoc trong")
    private String tenBaiTap;

    @NotEmpty(message = "noi dung k duoc trong")
    private String noiDung;

    @NotEmpty(message = "Dap an k duoc trong")
    private String dapAn;

}

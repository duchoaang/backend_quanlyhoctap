package com.ndh.hotrohoctap.dtos;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiemMonHocDTO {
    private String tenMonHoc;
    private double diem;
    private Long hocKi;
    private LocalDateTime thoiGian;

}

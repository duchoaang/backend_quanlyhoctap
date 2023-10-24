package com.ndh.hotrohoctap.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuanLyDiemMonHocDTO {
   private String idUser;
   private String idMonHoc;
   private double diem;
}

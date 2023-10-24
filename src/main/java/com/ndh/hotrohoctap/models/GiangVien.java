package com.ndh.hotrohoctap.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "giangvien")
@Data // to string
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenGiangVien", length = 255)
    private String tenGiangVien;

    @Column(name = "email", length = 255)
    private String email;
    private String soDienThoai;
    private Boolean active;
}

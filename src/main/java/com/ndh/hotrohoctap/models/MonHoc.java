package com.ndh.hotrohoctap.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monhoc")
@Data // to string
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maMonHoc;
    @Column(name = "tenMonHoc", nullable = false, length = 255)
    private String tenMonHoc;
    @Column(name = "soTinChi", nullable = false, length = 255)
    private String soTinChi;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "hocKi")
    private Long hocKi;
    @Column(name = "namHoc")
    private Long namHoc;
    @ManyToOne
    @JoinColumn(name = "giangvien_id")
    private GiangVien giangVien;

}

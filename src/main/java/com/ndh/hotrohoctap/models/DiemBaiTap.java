package com.ndh.hotrohoctap.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "diem_baitap")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiemBaiTap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "baitap_id")
    private BaiTap baiTap;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "diem", nullable = false)
    private double diem;

    @Column(name = "thoi_gian")
    private LocalDateTime thoiGian;
    @PrePersist
    protected void onCreate() {
        thoiGian = LocalDateTime.now();

    }

}

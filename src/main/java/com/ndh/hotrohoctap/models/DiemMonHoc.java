package com.ndh.hotrohoctap.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "diem_monhoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiemMonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHoc monHoc;

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

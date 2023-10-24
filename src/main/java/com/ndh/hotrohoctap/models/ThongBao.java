package com.ndh.hotrohoctap.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "thongbao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThongBao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "thoigian")
    private LocalDateTime thoigian;
    @PrePersist
    protected void onCreate() {
        thoigian = LocalDateTime.now();

    }
}

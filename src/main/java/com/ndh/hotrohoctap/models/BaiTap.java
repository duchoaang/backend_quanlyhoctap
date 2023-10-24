package com.ndh.hotrohoctap.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "baitap")

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaiTap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenBaiTap;


    private String noiDung;


    private String dapAn;

    @ManyToOne
    @JoinColumn(name = "monhoc_id")
    private MonHoc monHoc;

}

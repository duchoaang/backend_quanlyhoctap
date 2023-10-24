package com.ndh.hotrohoctap.repositories;

import com.ndh.hotrohoctap.models.DiemBaiTap;
import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.models.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiemBaiTapRepository extends JpaRepository<DiemBaiTap, Long> {
    List<DiemBaiTap> findAllByUserId(long id);

}

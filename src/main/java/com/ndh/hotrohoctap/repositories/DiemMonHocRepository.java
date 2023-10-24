package com.ndh.hotrohoctap.repositories;

import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.models.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiemMonHocRepository extends JpaRepository<DiemMonHoc, Long> {

    List<DiemMonHoc> findAllByUserId(long id);

    @Query("SELECT d FROM DiemMonHoc d WHERE d.diem < 5")
    List<DiemMonHoc> findDiemMonHocByDiemLessThan5();

    @Query("SELECT d FROM DiemMonHoc d WHERE d.diem > 8")
    List<DiemMonHoc> findDiemMonHocByDiemGreaterThan8();
}

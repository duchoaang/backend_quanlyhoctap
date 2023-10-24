package com.ndh.hotrohoctap.repositories;

import com.ndh.hotrohoctap.models.GiangVien;
import com.ndh.hotrohoctap.models.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonHocRepository extends JpaRepository<MonHoc, Long> {
}

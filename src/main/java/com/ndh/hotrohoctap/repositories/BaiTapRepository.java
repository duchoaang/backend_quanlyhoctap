package com.ndh.hotrohoctap.repositories;

import com.ndh.hotrohoctap.models.BaiTap;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BaiTapRepository extends JpaRepository<BaiTap, Long> {
    List<BaiTap> findByTenBaiTapContaining(String keyword);
}

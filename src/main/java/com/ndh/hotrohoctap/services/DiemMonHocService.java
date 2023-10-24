package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.dtos.QuanLyDiemMonHocDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.models.MonHoc;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.repositories.DiemMonHocRepository;
import com.ndh.hotrohoctap.repositories.MonHocRepository;
import com.ndh.hotrohoctap.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiemMonHocService implements IDiemMonHocService {
    private final DiemMonHocRepository diemMonHocRepository;
    private final MonHocRepository monHocRepository;
    private final UserRepository userRepository;

    @Override
    public List<DiemMonHoc> getDiemMonHocById(long id) {
        return diemMonHocRepository.findAllByUserId(id);
    }

    @Override
    public List<DiemMonHoc> getAllDiemMonHoc(){
        return diemMonHocRepository.findAll();
    }

    @Override
    public DiemMonHoc createDiemMonHoc(QuanLyDiemMonHocDTO quanLyDiemMonHocDTO) throws DataNotFoundException {
        MonHoc monhoc = monHocRepository.findById(Long.parseLong(quanLyDiemMonHocDTO.getIdMonHoc())).orElseThrow(() -> new DataNotFoundException("cannot find mon hoc"));
        User user = userRepository.findById(Long.parseLong(quanLyDiemMonHocDTO.getIdUser())).orElseThrow(() -> new DataNotFoundException("cannot find user"));

        DiemMonHoc diemMonHoc = DiemMonHoc.builder()
                .user(user)
                .monHoc(monhoc)
                .diem(quanLyDiemMonHocDTO.getDiem())
                .build();

        return diemMonHocRepository.save(diemMonHoc);
//        return null;
    }

    @Override
    public List<DiemMonHoc> findDiemMonHocByDiemGreaterThan8() {
        return diemMonHocRepository.findDiemMonHocByDiemGreaterThan8();
    }


    @Override
    public List<DiemMonHoc> findDiemMonHocByDiemLessThan5() {
        return diemMonHocRepository.findDiemMonHocByDiemLessThan5();
    }


}

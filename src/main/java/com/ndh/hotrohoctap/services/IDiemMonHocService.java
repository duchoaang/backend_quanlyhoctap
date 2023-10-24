package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.dtos.QuanLyDiemMonHocDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.DiemMonHoc;

import java.util.List;

public interface IDiemMonHocService {
     List<DiemMonHoc> getDiemMonHocById(long id) throws Exception;
     List<DiemMonHoc> getAllDiemMonHoc();

//     List<DiemMonHoc> getAllDiemMonHocByUserId()
     DiemMonHoc createDiemMonHoc (QuanLyDiemMonHocDTO quanLyDiemMonHocDTO) throws DataNotFoundException;

     List<DiemMonHoc> findDiemMonHocByDiemGreaterThan8();

     List<DiemMonHoc> findDiemMonHocByDiemLessThan5();

}

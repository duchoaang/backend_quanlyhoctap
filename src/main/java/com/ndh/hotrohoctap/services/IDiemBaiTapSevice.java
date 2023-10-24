package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.DiemBaiTapDTO;
import com.ndh.hotrohoctap.dtos.DiemMonHocDTO;
import com.ndh.hotrohoctap.dtos.NopBaiDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.DiemBaiTap;
import com.ndh.hotrohoctap.models.DiemMonHoc;

import java.util.List;

public interface IDiemBaiTapSevice {
    List<DiemBaiTap> getDiemBaiTapById(long id) throws Exception;
    DiemBaiTap createDiemBaiTap (DiemBaiTapDTO diemBaiTapDTO) throws DataNotFoundException;

}

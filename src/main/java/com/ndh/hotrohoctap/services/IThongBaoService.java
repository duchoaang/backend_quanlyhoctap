package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.ThongBao;

import java.util.List;

public interface IThongBaoService {
    ThongBao createThongBao (ThongBao thongBao);
    List<ThongBao> getALlThongBao();
}

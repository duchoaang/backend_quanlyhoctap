package com.ndh.hotrohoctap.services;


import com.ndh.hotrohoctap.models.MonHoc;

import java.util.List;

public interface IMonHocService {

    MonHoc getMonHocById(Long id);
    List<MonHoc> getAllMonHoc();
    void disableMonHoc(Long id);

}

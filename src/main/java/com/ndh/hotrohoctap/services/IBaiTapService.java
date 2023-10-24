package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.UpdateBaiTapDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import org.hibernate.sql.Update;

import java.util.List;

public interface IBaiTapService {
    BaiTap createBaiTap (BaiTapDTO baiTapDTO) throws DataNotFoundException;
    BaiTap getBaiTapById(long id);
    List<BaiTap> getAllBaiTap();
    BaiTap updateBaiTap(long baiTapId, UpdateBaiTapDTO baiTap);
    boolean deleteBaiTap(long id);

    List<BaiTap> searchBaiTap(String keyword);
}

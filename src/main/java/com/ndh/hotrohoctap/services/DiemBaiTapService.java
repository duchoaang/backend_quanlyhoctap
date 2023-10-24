package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.DiemBaiTapDTO;
import com.ndh.hotrohoctap.dtos.NopBaiDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.DiemBaiTap;
import com.ndh.hotrohoctap.models.DiemMonHoc;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.repositories.BaiTapRepository;
import com.ndh.hotrohoctap.repositories.DiemBaiTapRepository;
import com.ndh.hotrohoctap.repositories.DiemMonHocRepository;
import com.ndh.hotrohoctap.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiemBaiTapService implements IDiemBaiTapSevice{
    private final DiemBaiTapRepository diemBaiTapRepository;
    private final BaiTapRepository baiTapRepository;
    private final UserRepository userRepository;
    @Override
    public List<DiemBaiTap> getDiemBaiTapById(long id) throws Exception {
        return diemBaiTapRepository.findAllByUserId(id);
    }

    @Override
    public DiemBaiTap createDiemBaiTap(DiemBaiTapDTO diemBaiTapDTO) throws DataNotFoundException {
        BaiTap baiTap = baiTapRepository.findById(Long.parseLong(diemBaiTapDTO.getIdBaiTap())).orElseThrow(() -> new DataNotFoundException("cannot find baitap"));
        User user = userRepository.findById(Long.parseLong(diemBaiTapDTO.getIdNguoiDung())).orElseThrow(() -> new DataNotFoundException("cannot find baitap"));
        System.out.println(user);
        System.out.println(baiTap);
        DiemBaiTap newDiem = new DiemBaiTap();
        System.out.println(newDiem);
        newDiem.setBaiTap(baiTap);
        newDiem.setUser(user);
        newDiem.setDiem(Double.parseDouble("10"));
        System.out.println("Diem moi" + newDiem);
        return diemBaiTapRepository.save(newDiem);

    }



}

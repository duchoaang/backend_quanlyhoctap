package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.ThongBao;
import com.ndh.hotrohoctap.repositories.ThongBaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThongBaoService implements IThongBaoService{
    private final ThongBaoRepository thongBaoRepository;

    @Override
    public ThongBao createThongBao(ThongBao thongBao) {
        ThongBao thongBaonew = ThongBao.builder()
                .title(thongBao.getTitle())
                .content(thongBao.getContent())
                .build();
        return thongBaoRepository.save(thongBaonew);
    }

    @Override
    public List<ThongBao> getALlThongBao() {
        return thongBaoRepository.findAll();
    }
}

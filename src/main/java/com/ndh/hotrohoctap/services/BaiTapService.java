package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.BaiTapDTO;
import com.ndh.hotrohoctap.dtos.UpdateBaiTapDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.models.BaiTap;
import com.ndh.hotrohoctap.models.MonHoc;
import com.ndh.hotrohoctap.models.ThongBao;
import com.ndh.hotrohoctap.repositories.BaiTapRepository;
import com.ndh.hotrohoctap.repositories.MonHocRepository;
import com.ndh.hotrohoctap.repositories.ThongBaoRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaiTapService implements IBaiTapService{

    private final BaiTapRepository baiTapRepository;
    private final MonHocRepository monHocRepository;
    private final EmailService emailService;
    private final ThongBaoRepository thongBaoRepository;
    @Override
    public BaiTap createBaiTap(BaiTapDTO baiTapDTO) throws DataNotFoundException {
        MonHoc monhoc = monHocRepository.findById(Long.parseLong(baiTapDTO.getMonHocId())).orElseThrow(() -> new DataNotFoundException("cannot find baitap"));

        BaiTap baiTap = BaiTap.builder()
                .tenBaiTap(baiTapDTO.getTenBaiTap())
                .noiDung(baiTapDTO.getNoiDung())
                .dapAn(baiTapDTO.getDapAn())
                .monHoc(monhoc)
                .build();
        System.out.println("da vao day " + baiTap);
        ThongBao thongBao = ThongBao.builder()
                .title("Thông báo bài tập mới môn " + monhoc.getTenMonHoc())
                .content("Đã có bài tập mới của môn" + monhoc.getTenMonHoc())
                .build();
        thongBaoRepository.save(thongBao);
        return baiTapRepository.save(baiTap);
    }

    @Override
    public BaiTap getBaiTapById(long id) {
        return baiTapRepository.findById(id).orElseThrow(() -> new RuntimeException("Ko tim thay bai tap"));

    }

    @Override
    public List<BaiTap> getAllBaiTap() {
//        emailService.sendEmail("2051052047hoang@ou.edu.vn","Hello", "ADmin by hoang");
        return baiTapRepository.findAll();
    }

    @Override
    @Transactional
    public BaiTap updateBaiTap(long baiTapId, UpdateBaiTapDTO updateBaiTapDTO) {
        BaiTap exitingBaiTap = getBaiTapById(baiTapId);
        exitingBaiTap.setTenBaiTap(updateBaiTapDTO.getTenBaiTap());
        exitingBaiTap.setDapAn(updateBaiTapDTO.getDapAn());
        return exitingBaiTap;

    }

    @Override
    public boolean deleteBaiTap(long id) {
        Optional<BaiTap> baiTap = baiTapRepository.findById(id);
        if(baiTap.isPresent()){
            baiTapRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<BaiTap> searchBaiTap(String keyword) {
        return baiTapRepository.findByTenBaiTapContaining(keyword);
    }
}

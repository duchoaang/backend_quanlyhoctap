package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.models.MonHoc;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.repositories.MonHocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonHocService implements IMonHocService {

    private final MonHocRepository monHocRepository;

    @Override
    public MonHoc getMonHocById(Long id) {
        return null;
    }

    @Override
    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    @Override
    public void disableMonHoc(Long id) {
        Optional<MonHoc> optionalUser = monHocRepository.findById(id);
        if (optionalUser.isPresent()) {
            MonHoc mohoc = optionalUser.get();
            mohoc.setActive(false);
            monHocRepository.save(mohoc);

        } else {

        }
    }
}

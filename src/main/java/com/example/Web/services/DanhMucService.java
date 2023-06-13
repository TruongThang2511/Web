package com.example.Web.services;

import com.example.Web.entities.DanhMuc;
import com.example.Web.repositories.IDanhMucRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.SERIALIZABLE,
        rollbackFor = {Exception.class, Throwable.class})
public class DanhMucService {
    private final IDanhMucRepository danhMucRepository;
    public List<DanhMuc> getAllDanhMuc() {
        return danhMucRepository.findAll();
    }
    public Optional<DanhMuc> getDanhMucById(Long id) {
        return danhMucRepository.findById(id);
    }
    public void addDanhMuc(DanhMuc danhmuc) {
        danhMucRepository.save(danhmuc);
    }
    public void updateDanhMuc(@NotNull DanhMuc danhmuc) {
        DanhMuc existingDanhMuc = danhMucRepository
                .findById(danhmuc.getId())
                .orElse(null);
        Objects.requireNonNull(existingDanhMuc)
                .setName(danhmuc.getName());
        danhMucRepository.save(existingDanhMuc);
    }
    public void deleteDanhMucById(Long id) {
        danhMucRepository.deleteById(id);
    }
}

package com.example.Web.services;

import com.example.Web.entities.DanhMuc;
import com.example.Web.entities.Mau;
import com.example.Web.repositories.IDanhMucRepository;
import com.example.Web.repositories.IMauRepository;
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
public class MauService {
    private final IMauRepository mauRepository;
    public List<Mau> getAllMau() {
        return mauRepository.findAll();
    }
    public Optional<Mau> getMauById(Long id) {
        return mauRepository.findById(id);
    }
    public void addMau(Mau mau) {
        mauRepository.save(mau);
    }
    public void updateMau(@NotNull Mau mau) {
        Mau existingMau = mauRepository
                .findById(mau.getId())
                .orElse(null);
        Objects.requireNonNull(existingMau)
                .setName(mau.getName());
        mauRepository.save(existingMau);
    }
    public void deleteDanhMucById(Long id) {
        mauRepository.deleteById(id);
    }
}

package com.example.Web.services;

import com.example.Web.entities.NhomSanPham;
import com.example.Web.repositories.INhomSanPhamRepository;
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
public class NhomSanPhamService {
    private final INhomSanPhamRepository nhomsanphamRepository;
    public List<NhomSanPham> getAllNhomSanPham() {return nhomsanphamRepository.findAll();}
    public Optional<NhomSanPham> getNhomSPById(Long id) {
        return nhomsanphamRepository.findById(id);
    }
    public void addNhomSanPham(NhomSanPham nhomsanpham) {
        nhomsanphamRepository.save(nhomsanpham);
    }

    public void updateNhomSP(@NotNull NhomSanPham nhomsanpham) {
        NhomSanPham existingNhomSP = nhomsanphamRepository.findById(nhomsanpham.getId())
                .orElse(null);
        Objects.requireNonNull(existingNhomSP).setName(nhomsanpham.getName());
        existingNhomSP.setDanhMuc(nhomsanpham.getDanhMuc());
        nhomsanphamRepository.save(existingNhomSP);
    }
    public void deleteNhomSPById(Long id) {
        nhomsanphamRepository.deleteById(id);
    }
}

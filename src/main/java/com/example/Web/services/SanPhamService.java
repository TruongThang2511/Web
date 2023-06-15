package com.example.Web.services;

import com.example.Web.entities.SanPham;
import com.example.Web.repositories.ISanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class SanPhamService {
    private final ISanPhamRepository sanphamRepository;
    public Page<SanPham> getSanPham(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanphamRepository.findAll(pageable);
    }
    public Optional<SanPham> getSanPhamById(Long id) {
        return sanphamRepository.findById(id);
    }
    public void addSanPham(SanPham sanpham) {
        sanphamRepository.save(sanpham);
    }

    public void updateSanPham(@NotNull SanPham sanpham) {
        SanPham existingSanPham = sanphamRepository.findById(sanpham.getId())
                .orElse(null);
        Objects.requireNonNull(existingSanPham).setTitle(sanpham.getTitle());
        existingSanPham.setPrice(sanpham.getPrice());
        existingSanPham.setDanhmuc(sanpham.getDanhmuc());
        existingSanPham.setMau(sanpham.getMau());
        sanphamRepository.save(existingSanPham);
    }
    public void deleteSanPhamById(Long id) {
        sanphamRepository.deleteById(id);
    }
    public List<SanPham> getAllSanPhamByDanhMucId(int id) {
        return sanphamRepository.findAllByDanhmuc_Id(id);
    }
    public List<SanPham> searchSanPham(String keyword) {
        return sanphamRepository.searchSanPham(keyword);
    }
}

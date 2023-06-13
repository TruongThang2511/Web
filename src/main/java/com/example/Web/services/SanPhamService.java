package com.example.Web.services;

import com.example.Web.entities.SanPham;
import com.example.Web.repositories.ISanPhamRepository;
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
public class SanPhamService {
    private final ISanPhamRepository sanphamRepository;
    public List<SanPham> getAllBooks(Integer pageNo,
                                     Integer pageSize,
                                     String sortBy) {

        return sanphamRepository.findAllSP(pageNo, pageSize, sortBy);
    }
    public Optional<SanPham> getSanPhamById(Long id) {
        return sanphamRepository.findById(id);
    }
    public void addBook(SanPham sanpham) {
        sanphamRepository.save(sanpham);
    }

    public void updateBook(@NotNull SanPham sanpham) {
        SanPham existingSanPham = sanphamRepository.findById(sanpham.getId())
                .orElse(null);
        Objects.requireNonNull(existingSanPham).setTitle(sanpham.getTitle());
        existingSanPham.setPrice(sanpham.getPrice());
        existingSanPham.setNhomsanpham(sanpham.getNhomsanpham());
        existingSanPham.setMau(sanpham.getMau());
        sanphamRepository.save(existingSanPham);
    }
    public void deleteSanPhamById(Long id) {
        sanphamRepository.deleteById(id);
    }
    public List<SanPham> searchBook(String keyword) {
        return sanphamRepository.searchSanPham(keyword);
    }
}

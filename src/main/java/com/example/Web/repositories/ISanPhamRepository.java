package com.example.Web.repositories;

import com.example.Web.entities.SanPham;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISanPhamRepository extends PagingAndSortingRepository<SanPham, Long>,JpaRepository<SanPham, Long> {
    default List<SanPham> findAllSP(Integer pageNo,
                                    Integer pageSize,
                                    String sortBy) {
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy))).getContent();
    }
    List<SanPham> findAllByDanhmuc_Id(int id);
    @Query("""
            SELECT b FROM SanPham b
            WHERE b.title LIKE %?1%
            OR b.danhmuc.name LIKE %?1%
            OR b.mau.name LIKE %?1%
            """)
    List<SanPham> searchSanPham(String keyword);
}

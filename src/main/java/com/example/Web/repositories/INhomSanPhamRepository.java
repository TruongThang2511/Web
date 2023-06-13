package com.example.Web.repositories;

import com.example.Web.entities.NhomSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhomSanPhamRepository extends JpaRepository<NhomSanPham, Long> {
}

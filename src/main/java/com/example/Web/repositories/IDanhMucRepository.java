package com.example.Web.repositories;

import com.example.Web.entities.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDanhMucRepository extends JpaRepository<DanhMuc, Long> {
}

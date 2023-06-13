package com.example.Web.repositories;

import com.example.Web.entities.Mau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMauRepository extends JpaRepository<Mau, Long> {
}

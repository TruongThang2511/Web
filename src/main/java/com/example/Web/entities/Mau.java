package com.example.Web.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Mau")
public class Mau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @OneToMany(mappedBy = "mau", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SanPham> sanpham = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        Mau mau = (Mau) o;
        return getId() != null && Objects.equals(getId(),
                mau.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.example.Web.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
@Table(name = "Danhmuc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @OneToMany(mappedBy = "danhmuc", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SanPham> sanphams = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        DanhMuc danhMuc = (DanhMuc) o;
        return getId() != null && Objects.equals(getId(),
                danhMuc.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

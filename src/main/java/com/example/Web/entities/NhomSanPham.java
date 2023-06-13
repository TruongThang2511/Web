package com.example.Web.entities;

import com.example.Web.validators.annotations.ValidDanhMucId;
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
@Table(name = "Nhomsanpham")
public class NhomSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "danhmuc_id", referencedColumnName = "id")
    @ToString.Exclude
    @ValidDanhMucId
    private DanhMuc danhMuc;

    @OneToMany(mappedBy = "nhomsanpham", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SanPham> sanpham = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        NhomSanPham nhomSanPham = (NhomSanPham) o;
        return getId() != null && Objects.equals(getId(),
                nhomSanPham.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

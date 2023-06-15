package com.example.Web.entities;

import com.example.Web.validators.annotations.ValidMauId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Title must be between 1 and 50 characters")
    @NotBlank(message = "Title must not be blank")
    private String title;

    @Column(name = "price")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    public String getFormattedPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "danhmuc_id", referencedColumnName = "id")
    @ToString.Exclude
    private DanhMuc danhmuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mau_id", referencedColumnName = "id")
    @ValidMauId
    @ToString.Exclude
    private Mau mau;

    @OneToMany(mappedBy = "sanpham", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ItemInvoice> itemInvoices = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SanPham sanPham = (SanPham) o;
        return getId() != null && Objects.equals(getId(),
                sanPham.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

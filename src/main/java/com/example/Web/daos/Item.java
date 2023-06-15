package com.example.Web.daos;

import com.example.Web.entities.Mau;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long productId;
    private String productName;
    private Double price;
    public String getFormattedPrice(Double gia) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(gia);
    }
    private String productMau;
    private int quantity;
}

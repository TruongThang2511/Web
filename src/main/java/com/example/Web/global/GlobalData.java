package com.example.Web.global;

import com.example.Web.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    //tao bien toan cuc
    public static List<SanPham> cart;

    static {
        cart = new ArrayList<>();
    }

}

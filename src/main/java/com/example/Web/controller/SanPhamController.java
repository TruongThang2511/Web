package com.example.Web.controller;

import com.example.Web.daos.Item;
import com.example.Web.entities.Mau;
import com.example.Web.entities.SanPham;
import com.example.Web.services.CartService;
import com.example.Web.services.DanhMucService;
import com.example.Web.services.MauService;
import com.example.Web.services.SanPhamService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/sanphams")
@RequiredArgsConstructor
public class SanPhamController {
    private final SanPhamService sanphamService;
    private final MauService mauService;
    private final DanhMucService danhmucService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";


    private final CartService cartService;
    @GetMapping
    public String showAllSanPhams(
            @NotNull Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("sanphams", sanphamService.getAllSanPhams(pageNo,
                pageSize, sortBy));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("danhmucs",
                danhmucService.getAllDanhMuc());
        model.addAttribute("maus",
                mauService.getAllMau());
        model.addAttribute("totalPages",
                sanphamService.getAllSanPhams(pageNo, pageSize, sortBy).size() / pageSize);
        return "sanpham/list";
    }
    @GetMapping("/add")
    public String addSanPhamForm(@NotNull Model model) {
        model.addAttribute("sanpham",new SanPham());
        model.addAttribute("danhmucs",
                danhmucService.getAllDanhMuc());
        model.addAttribute("maus",
                mauService.getAllMau());
        return "sanpham/add";
    }
    @PostMapping("/add")
    public String addSanPham(
            @Valid @ModelAttribute("sanpham") SanPham sanpham,
            @NotNull BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            model.addAttribute("danhmucs",
                    danhmucService.getAllDanhMuc());
            model.addAttribute("maus",
                    mauService.getAllMau());
            return "sanpham/add";
        }
        sanphamService.addSanPham(sanpham);
        return "redirect:/sanphams";
    }

    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable long id) {
        sanphamService.getSanPhamById(id)
                .ifPresentOrElse(
                        book -> sanphamService.deleteSanPhamById(id),
                        () -> { throw new IllegalArgumentException("Product not found"); });
        return "redirect:/sanphams";
    }

    @GetMapping("/edit/{id}")
    public String editSanPhamForm(@NotNull Model model, @PathVariable long id)
    {
        var sanpham = sanphamService.getSanPhamById(id);
        model.addAttribute("sanpham", sanpham.orElseThrow(() -> new IllegalArgumentException("Product not found")));
        model.addAttribute("danhmucs", danhmucService.getAllDanhMuc());
        model.addAttribute("maus", mauService.getAllMau());
        return "sanpham/edit";
    }
    @PostMapping("/edit")
    public String editSanPham(@Valid @ModelAttribute("sanpham") SanPham sanpham,
                           @NotNull BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toArray(String[]::new);
            model.addAttribute("errors", errors);
            model.addAttribute("danhmucs",
                    danhmucService.getAllDanhMuc());
            model.addAttribute("maus",
                    mauService.getAllMau());
            return "sanpham/edit";
        }
        sanphamService.updateSanPham(sanpham);
        return "redirect:/sanphams";
    }

    @GetMapping("/search")
    public String searchSanPham(
            @NotNull Model model,
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("sanphams", sanphamService.searchSanPham(keyword));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages",
                sanphamService
                        .getAllSanPhams(pageNo, pageSize, sortBy)
                        .size() / pageSize);
        model.addAttribute("danhmucs",
                danhmucService.getAllDanhMuc());
        model.addAttribute("maus",
                mauService.getAllMau());
        return "sanpham/list";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(HttpSession session,
                            @RequestParam long id,
                            @RequestParam String name,
                            @RequestParam String color,
                            @RequestParam double price,
                            @RequestParam(defaultValue = "1") int quantity)
    {
        var cart = cartService.getCart(session);
        cart.addItems(new Item(id, name, price, color, quantity));
        cartService.updateCart(session, cart);
        return "redirect:/sanphams";
    }
    @GetMapping("/viewproduct/{id}")
    public String viewProduct(@PathVariable long id, Model model){
        model.addAttribute("sanpham", sanphamService.getSanPhamById(id).get());
/*        Item it = new Item();
        it.getProductMau()*/
        return "sanpham/viewProduct";
    }
    @PostMapping("/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        return "redirect:/sanpham/index";
    }
}

package com.example.webcaycanh.Controller;

import com.example.webcaycanh.Services.ProductService;
import com.example.webcaycanh.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public String home() {
        return "/Admin/index";
    }

    @GetMapping("/list")
    public String showALLProduct(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "/Admin/list";
    }
}

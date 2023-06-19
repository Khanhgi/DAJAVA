package com.example.webcaycanh.Controller;

import com.example.webcaycanh.Services.ProductService;
import com.example.webcaycanh.entity.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.example.webcaycanh.Services.CategoryService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String showALLProduct(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);

        if(product == null) {
//            thêm thông báo không tìm thấy sản phẩm

            return "error";
        }

        model.addAttribute("product", product);
        return "product/detail";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("product") @Valid Product product, BindingResult result, @RequestParam("imgProduct") MultipartFile imgProduct) {
//        
        if (result.hasErrors()) {
            // Xử lý lỗi xác thực (nếu có)
            return "products/add";
        }

        if (!imgProduct.isEmpty()) {
            try {
                byte[] bytes = imgProduct.getBytes();
                product.setImage(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//
        productService.addProduct(product);

        return "redirect:/products/list";
    }

//    @PostMapping("/add")
//    public String addProductForm(@Valid Product product, Errors error, Model model){
//        if(null != error && error.getErrorCount() > 0) {
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "product/add";
//        } else {
//            productService.addProduct(product);
//            return "redirect:product/list";
//        }
//    }
//
//    @GetMapping("/add")
//    public String addProduct(Product product, Model model){
//        model.addAttribute("product", new Product());
//        model.addAttribute("categories", categoryService.getAllCategories());
//        return "Client/product/add";
//    }

//    @GetMapping("/edit/{id}")
//    public String editProductForm(@PathVariable("id") Long id, Model model){
//        Product product = productService.getProductById(id);
//        if(product != null)
//        {
//            model.addAttribute("product", product);
//            model.addAttribute("currentCategory", product.getCategory());
//            model.addAttribute("categories", categoryService.getAllCategories());
//            return "Client/product/edit";
//        }else {
//            return "Client/product/list";
//        }
//    }
//
//    @PostMapping("/edit")
//    public String editProduct(@ModelAttribute("product") Product product){
//        productService.updateProduct(product);
//        return "redirect:Client/product/list";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable("id") Long id){
//        productService.deleteProduct(id);
//        return "redirect:Client/product/list";
//    }

}

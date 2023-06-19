//package com.example.webcaycanh.Controller;
//
//import com.example.webcaycanh.Services.ProductService;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//@Controller
//public class ImageController {
//    private final ProductService productService;
//
//    public ImageController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping(value = "/product/image/{productId}", produces = MediaType.IMAGE_PNG_VALUE)
//    @ResponseBody
//    public String getProductImage(@PathVariable("productId") Long productId) {
//        // Retrieve the product image from the database as a byte array
//        byte[] imageData = productService.getProductImageById(productId);
//
//        // Convert the byte array to Base64
//        String base64Image = Base64.getEncoder().encodeToString(imageData);
//
//        return base64Image;
//    }
//}

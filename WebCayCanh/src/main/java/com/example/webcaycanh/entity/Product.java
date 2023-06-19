package com.example.webcaycanh.entity;

import com.example.webcaycanh.validator.annotation.ValidCategoryId;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Base64;


@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50)
    @Size(max = 50, message = "Tên sản phẩm không quá 50 kí tự")
    @NotNull(message = "Tên sản phẩm không được để trống")
    private String title;

    @Column(name = "imgProduct", columnDefinition = "TEXT")
    private String imgProduct; // Thay đổi kiểu dữ liệu thành String

    @Column(name = "price")
    @NotNull(message = "Giá tiền sản phẩm không được để trống")
    @Positive(message = "Giá tiền không được bằng 0")
    private Double price;

    @Column(name = "total_product")
    @NotNull(message = "Số lượng sản phẩm không được để trống")
    private String totalProduct;

    @Column(name = "description", length = 500)
    @Size(max = 500, message = "Mô tả sản phẩm không quá 500 kí tự")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<Orders> orders = new HashSet<>();


    public void setImgProduct(MultipartFile imgProduct) {
        if (imgProduct != null && !imgProduct.isEmpty()) {
            try {
                byte[] imageData = imgProduct.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(imageData);
                this.imgProduct = base64Image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setImage(byte[] image) {
        this.imgProduct = Base64.getEncoder().encodeToString(image);
    }
}










// ------------- Không bỏ code này ------------------


//@Data
//@Entity
//@Table(name = "product")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "title", length = 50)
//    @Size(max = 50, message = "Tên sản phẩm không quá 50 kí tự")
//    @NotNull(message = "Tên sản phẩm không được để trống")
//    private String title;
//
//    @Transient
//    private MultipartFile imgProduct;
//
////    @Column(name = "imgProduct", columnDefinition = "TEXT")
////    @Lob
////    private byte[] image;
//
//    @Column(name = "price")
//    @NotNull(message = "Giá tiền sản phẩm không được để trống")
//    @Positive(message = "Giá tiền không được bằng 0")
//    private Double price;
//
//    @Column(name = "total_product")
//    @NotNull(message = "Số lượng sản phẩm không được để trống")
//    private String totalProduct;
//
//    @Column(name = "description", length = 500)
//    @Size(max = 500, message = "Mô tả sản phẩm không quá 500 kí tự")
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @ManyToMany(mappedBy = "products")
//    private Set<Orders> orders = new HashSet<>();
//
//
//
////
////    public void setImgProduct(MultipartFile imgProduct) {
////        this.imgProduct = imgProduct;
////        if (imgProduct != null && !imgProduct.isEmpty()) {
////            try {
////                this.image = imgProduct.getBytes();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//}

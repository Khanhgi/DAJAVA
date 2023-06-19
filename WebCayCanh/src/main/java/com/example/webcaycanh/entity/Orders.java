package com.example.webcaycanh.entity;

import com.example.webcaycanh.validator.annotation.ValidRoleId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname", length = 50, nullable = false, unique = true)
    @NotBlank(message = "User is required")
    @Size(max = 50, message = "Username must be less than 50 characters")
//    @ValidUsername
    private String fullname;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    @NotBlank(message = "User is required")
    @Size(max = 50, message = "Username must be less than 50 characters")
    private String email;

    @Column(name = "phone", length = 20, nullable = false)
    @Size(max = 20, message = "Phone must be less than 20 characters")
    private String phone;

    @Column(name = "address", length = 150, nullable = false)
    @Size(max = 150, message = "Your emaill must be less than 150 characters")
    private String address;

    @Column(name = "total_amount", length = 150, nullable = false)
    private int total_amount;

    @ManyToMany
    @JoinTable(name = "order_detail",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

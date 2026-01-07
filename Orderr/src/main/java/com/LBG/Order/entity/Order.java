package com.LBG.Order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity                     
@Table(name = "orders")    
@Getter                     
@Setter                     
@NoArgsConstructor          
@AllArgsConstructor         
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String orderNumber;


    @Column(nullable = false)
    private Long userId;


    @Column(nullable = false)
    private BigDecimal totalAmount;


    @Column(nullable = false)
    private String status;


    @Column(nullable = false)
    private LocalDateTime createdAt;
}

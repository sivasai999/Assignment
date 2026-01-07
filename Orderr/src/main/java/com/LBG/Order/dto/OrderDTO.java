package com.LBG.Order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    @NotBlank
    private String orderNumber;

    @NotNull
    private Long userId;

    @NotNull
    
    private BigDecimal totalAmount;

    @NotBlank
    private String status;

    private LocalDateTime createdAt;
}

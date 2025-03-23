package com.app.javacleanarchitect.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Integer customerId;
    private Integer productId;
    private int quantity;
    private double price;
    private String promoCode;
    private LocalDateTime orderDate;
}

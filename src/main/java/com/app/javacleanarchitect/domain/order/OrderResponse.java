package com.app.javacleanarchitect.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String orderId;
    private String customerId;
    private String productId;
    private int quantity;
    private double price;
    private LocalDateTime orderDate;
}

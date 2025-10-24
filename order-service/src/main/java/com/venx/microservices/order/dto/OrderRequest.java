package com.venx.microservices.order.dto;


import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, Integer quantity, String skuCode , BigDecimal price) {
}

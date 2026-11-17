package com.tecsup.minishop.dto;

import com.tecsup.minishop.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRequestTest {

    @Test
    void shouldMapAllowedFieldsToProduct() {
        ProductRequest request = new ProductRequest("Teclado", 89.9, 12);

        Product product = request.toEntity();

        assertEquals("Teclado", product.getName());
        assertEquals(89.9, product.getPrice());
        assertEquals(12, product.getStock());
    }
}

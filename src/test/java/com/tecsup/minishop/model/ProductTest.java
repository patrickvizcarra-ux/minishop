package com.tecsup.minishop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void shouldExposeValuesFromConstructorAndAccessors() {
        Product product = new Product(7L, "Teclado", 89.9, 12);

        assertEquals(7L, product.getId());
        assertEquals("Teclado", product.getName());
        assertEquals(89.9, product.getPrice());
        assertEquals(12, product.getStock());

        product.setId(8L);
        product.setName("Mouse");
        product.setPrice(45.5);
        product.setStock(9);

        assertEquals(8L, product.getId());
        assertEquals("Mouse", product.getName());
        assertEquals(45.5, product.getPrice());
        assertEquals(9, product.getStock());
    }

    @Test
    void shouldBuildProductWithAllValues() {
        Product product = Product.builder()
            .id(2L)
            .name("Monitor")
            .price(599.0)
            .stock(3)
            .build();

        assertEquals(2L, product.getId());
        assertEquals("Monitor", product.getName());
        assertEquals(599.0, product.getPrice());
        assertEquals(3, product.getStock());
    }
}

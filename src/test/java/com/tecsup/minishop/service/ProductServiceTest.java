package com.tecsup.minishop.service;

import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    void shouldRejectProductWithZeroPrice() {
        Product product = Product.builder().name("Producto inválido").price(0.0).stock(5).build();

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    void shouldRejectProductWithNegativeStock() {
        Product product = Product.builder().name("Producto sin stock").price(10.0).stock(-1).build();

        assertThrows(IllegalArgumentException.class, () -> productService.save(product));
    }

    @Test
    void shouldSaveValidProductWithoutThrowing() {
        Product product = Product.builder().name("Producto válido").price(10.0).stock(5).build();
        when(productRepository.save(any(Product.class))).thenReturn(product);

        assertDoesNotThrow(() -> productService.save(product));
    }
}

package com.letscode.store.dto;

import com.letscode.store.model.Client;
import com.letscode.store.model.Product;
import com.letscode.store.model.PurchaseProduct;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDTO {
    private int productCode;
    private int quantity;
    private double price;

    public static ProductDTO convert(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductCode(product.getProductCode());
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public static ProductDTO convert(PurchaseProduct purchaseProduct) {
        ProductDTO dto = new ProductDTO();
        dto.setProductCode(purchaseProduct.getProduct().getProductCode());
        dto.setQuantity(purchaseProduct.getQuantityPurchased());
        dto.setPrice(purchaseProduct.getProduct().getPrice());
        return dto;
    }
}

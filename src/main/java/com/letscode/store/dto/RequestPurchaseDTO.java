package com.letscode.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RequestPurchaseDTO {

    private String cpf;
    private List<PurchaseSaveProductDTO> products;
}

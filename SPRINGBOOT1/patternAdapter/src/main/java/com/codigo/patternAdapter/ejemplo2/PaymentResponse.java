package com.codigo.patternAdapter.ejemplo2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private Long id;
    private String status;
    private Double amount;
}

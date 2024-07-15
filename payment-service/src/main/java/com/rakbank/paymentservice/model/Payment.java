package com.rakbank.paymentservice.model;

import lombok.Data;

@Data
public class Payment {
    private Long studentId;
    private Double amount;
    private String paymentDetails;
}


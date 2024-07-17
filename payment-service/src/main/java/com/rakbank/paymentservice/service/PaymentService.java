package com.rakbank.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${receipt.service.url}")
    private String receiptServiceUrl;

    public void processPayment(Long studentId, Double amount, String paymentDetails) {
        //TODO it is possible to handle payment separately to fully organize handling multiple payments and transactions here. basically it's just a mock
        Map<String, Object> receiptRequest = new HashMap<>();
        receiptRequest.put("studentId", studentId);
        receiptRequest.put("amount", amount);
        receiptRequest.put("date", LocalDate.now());
        receiptRequest.put("details", paymentDetails);
        receiptRequest.put("status", "PAID");

        // Most simple communication as possible, can be used kafka, rabbitMQ or any other tool
        restTemplate.postForObject(receiptServiceUrl, receiptRequest, Void.class);
    }
}


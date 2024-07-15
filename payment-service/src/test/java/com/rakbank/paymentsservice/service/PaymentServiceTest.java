package com.rakbank.paymentsservice.service;

import com.rakbank.paymentservice.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testProcessPayment() {
        when(restTemplate.postForObject(any(String.class), any(Object.class), eq(Void.class))).thenReturn(null);

        Long studentId = 1L;
        Double amount = 500.0;
        String paymentDetails = "Test payment";

        Map<String, Object> receiptRequest = new HashMap<>();
        receiptRequest.put("studentId", studentId);
        receiptRequest.put("amount", amount);
        receiptRequest.put("date", LocalDate.now());
        receiptRequest.put("details", paymentDetails);
        receiptRequest.put("status", "PAID");

        paymentService.processPayment(studentId, amount, paymentDetails);

        verify(restTemplate, times(1)).postForObject(eq("http://localhost:8081/api/receipts"), any(Map.class), eq(Void.class));
    }
}
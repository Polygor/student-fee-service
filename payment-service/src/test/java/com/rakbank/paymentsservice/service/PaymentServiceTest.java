package com.rakbank.paymentsservice.service;

import com.rakbank.paymentservice.service.PaymentService;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private RestTemplate restTemplate;

    private static final String MOCK_RECEIPT_SERVICE_URL = "http://mock-url/api/receipts";

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        setMockReceiptServiceUrl();
    }

    private void setMockReceiptServiceUrl() throws Exception {
        Field field = PaymentService.class.getDeclaredField("receiptServiceUrl");
        field.setAccessible(true);
        field.set(paymentService, MOCK_RECEIPT_SERVICE_URL);
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

        verify(restTemplate, times(1)).postForObject(eq(MOCK_RECEIPT_SERVICE_URL), any(Map.class), eq(Void.class));
    }
}
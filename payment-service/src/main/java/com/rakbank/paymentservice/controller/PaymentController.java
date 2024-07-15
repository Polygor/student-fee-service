package com.rakbank.paymentservice.controller;

import com.rakbank.paymentservice.model.Payment;
import com.rakbank.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public void processPayment(@RequestBody Payment payment) {
        paymentService.processPayment(payment.getStudentId(), payment.getAmount(), payment.getPaymentDetails());
    }
}

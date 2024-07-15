package com.rakbank.receiptservice.controller;

import com.rakbank.receiptservice.model.Receipt;
import com.rakbank.receiptservice.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{id}")
    public Receipt getReceiptById(@PathVariable Long id) {
        return receiptService.getReceiptById(id);
    }

    @PostMapping
    public Receipt saveReceipt(@RequestBody Receipt receipt) {
        return receiptService.saveReceipt(receipt);
    }

    @PutMapping("/{id}/status")
    public void updateReceiptStatus(@PathVariable Long id, @RequestParam String status) {
        receiptService.updateReceiptStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        receiptService.deleteReceipt(id);
    }
}

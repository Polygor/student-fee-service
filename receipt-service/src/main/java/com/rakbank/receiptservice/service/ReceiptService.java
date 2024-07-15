package com.rakbank.receiptservice.service;

import com.rakbank.receiptservice.model.Receipt;
import com.rakbank.receiptservice.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(Long id) {
        return receiptRepository.findById(id).orElse(null);
    }

    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public void updateReceiptStatus(Long id, String status) {
        Receipt receipt = receiptRepository.findById(id).orElse(null);
        if (receipt != null) {
            receipt.setStatus(status);
            receiptRepository.save(receipt);
        }
    }

    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }
}

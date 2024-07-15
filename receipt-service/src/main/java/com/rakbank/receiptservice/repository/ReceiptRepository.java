package com.rakbank.receiptservice.repository;


import com.rakbank.receiptservice.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}

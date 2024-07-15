package com.rakbank.receiptservice.service;

import com.rakbank.receiptservice.model.Receipt;
import com.rakbank.receiptservice.repository.ReceiptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReceiptServiceTest {

    @InjectMocks
    private ReceiptService receiptService;

    @Mock
    private ReceiptRepository receiptRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllReceipts() {
        when(receiptRepository.findAll()).thenReturn(List.of(new Receipt(), new Receipt()));

        assertEquals(2, receiptService.getAllReceipts().size());
    }

    @Test
    void testGetReceiptById() {
        Receipt receipt = new Receipt();
        receipt.setId(1L);
        when(receiptRepository.findById(1L)).thenReturn(Optional.of(receipt));

        assertEquals(receipt, receiptService.getReceiptById(1L));
    }

    @Test
    void testSaveReceipt() {
        Receipt receipt = new Receipt();
        when(receiptRepository.save(any(Receipt.class))).thenReturn(receipt);

        assertEquals(receipt, receiptService.saveReceipt(receipt));
    }

    @Test
    void testDeleteReceipt() {
        doNothing().when(receiptRepository).deleteById(1L);
        receiptService.deleteReceipt(1L);

        verify(receiptRepository, times(1)).deleteById(1L);
    }
}

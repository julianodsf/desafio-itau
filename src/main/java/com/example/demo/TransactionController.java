package com.example.demo;

import com.example.demo.GlobalExceptionHandler;
import com.example.demo.Statistic;
import com.example.demo.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transacao")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction) {
        if (transaction.getValor() <= 0 || transaction.getDataHora().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        }
        else {
            transactionService.addTransaction(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @DeleteMapping("/transacao")
    public void deleteTransactions() {
        transactionService.deleteTransactions();
    }

    @GetMapping("/estatistica")
    public Statistic transactionsStatistics() {
        return transactionService.getAllLastMinuteStatistics();
    }
}

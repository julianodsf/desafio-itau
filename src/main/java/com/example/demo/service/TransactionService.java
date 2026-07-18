package com.example.demo.service;

import com.example.demo.Statistic;
import com.example.demo.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void deleteTransactions() {
        transactions.clear();
    }

    public Statistic getAllLastMinuteStatistics() {
        List<Transaction> lastMinuteTransactions = transactions;
        OffsetDateTime currentTime = OffsetDateTime.now().minusMinutes(1);
        lastMinuteTransactions.removeIf(t -> currentTime.isAfter(t.getDataHora()));
        Statistic st = new Statistic();
        if (!lastMinuteTransactions.isEmpty()) {
            st.count = lastMinuteTransactions.size();
            st.min = lastMinuteTransactions.get(0).getValor();
            for (Transaction lastMinuteTransaction : lastMinuteTransactions) {
                st.sum += lastMinuteTransaction.getValor();
                st.max = Math.max(st.max, lastMinuteTransaction.getValor());
                st.min = Math.min(st.min, lastMinuteTransaction.getValor());
            }
            st.avg = st.sum / st.count;
        }

        return st;
    }
}

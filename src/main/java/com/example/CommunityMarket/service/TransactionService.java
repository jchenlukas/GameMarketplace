package com.example.CommunityMarket.service;

import com.example.CommunityMarket.model.Negotiation;
import com.example.CommunityMarket.repository.TransactionRepository;
import com.example.CommunityMarket.model.Transaction;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class TransactionService {

    @Autowired

    TransactionRepository transactionRepo;

    public List<Transaction> getByID(Integer transactionID) {
        Optional<Transaction> result = transactionRepo.findById(transactionID);
        if (result.isPresent()) {
            Transaction transactionResult = result.get();
            return List.of(transactionResult);
        }
        return Collections.emptyList();
    }
    public List<Transaction> getTransactionByTemplate(Integer transaction_id,
                                                      String buyer_id,
                                                      String seller_id,
                                                      Integer quantity,
                                                      Boolean is_open,
                                                      LocalDateTime post_time,
                                                      LocalDateTime close_time,
                                                      Integer price,
                                                      Boolean is_accept){
        return transactionRepo.findByTemplate(transaction_id,buyer_id,seller_id,quantity,is_open,post_time,close_time,price,is_accept);
    }

    public List<Transaction> addTransaction(Transaction transaction) {
        LocalDateTime time = LocalDateTime.now();
        transaction.setPostTime(time);
        Transaction result = transactionRepo.save(transaction);
        return List.of(result);
    }
    public List<Transaction> updateTransaction(Transaction transaction) throws IllegalArgumentException {
        if (getByID(transaction.getTransactionID()).size() >= 1) {
            Transaction result = transactionRepo.save(transaction);
            return List.of(result);
        } else {
            throw new IllegalArgumentException("Transaction not found by ID in DB, cannot update");
        }
    }

}

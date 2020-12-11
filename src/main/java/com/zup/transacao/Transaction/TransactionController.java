package com.zup.transacao.Transaction;

import com.zup.transacao.Transaction.dto.TransactionResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactions(@PathVariable(name = "id") String id) {
        List<Transaction> result = transactionRepository.findTop10ByCardId(id);

        List<TransactionResponse> response = result.stream().map(transaction -> new TransactionResponse(transaction)).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}

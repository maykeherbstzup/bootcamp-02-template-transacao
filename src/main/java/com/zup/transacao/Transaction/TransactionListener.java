package com.zup.transacao.Transaction;

import com.zup.transacao.Transaction.dto.TransactionEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {
    @Autowired
    TransactionRepository transactionRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionEventResponse transactionEventResponse) {
        Transaction transaction = transactionEventResponse.toModel();

        transactionRepository.save(transaction);
    }
}

package com.zup.transacao.Transaction.dto;

import com.zup.transacao.Transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private String cardId;
    private String cardEmail;
    private String storeName;
    private String storeCity;
    private String storeAddress;

    public TransactionResponse(Transaction transaction) {
        this.valor = transaction.getValue();
        this.efetivadaEm = transaction.getEffectiveOn();
        this.cardId = transaction.getCardId();
        this.cardEmail = transaction.getEmail();
        this.storeName = transaction.getName();
        this.storeCity = transaction.getCity();
        this.storeAddress = transaction.getAddress();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public String getCardId() {
        return cardId;
    }

    public String getCardEmail() {
        return cardEmail;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public String getStoreAddress() {
        return storeAddress;
    }
}

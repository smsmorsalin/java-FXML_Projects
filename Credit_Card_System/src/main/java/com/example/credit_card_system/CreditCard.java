package com.example.credit_card_system;

import java.time.LocalDate;

public class CreditCard {
    private String cardNo;
    private String holderName;
    private LocalDate dateOfExpiry;
    private int CreditLimit;
    private String gatewayName;
    private String cardType;

    public CreditCard(String cardNo, String holderName, LocalDate dateOfExpiry, String gatewayName, String cardType, int CreditLimit) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.dateOfExpiry = dateOfExpiry;
        this.gatewayName = gatewayName;
        this.cardType = cardType;
        this.CreditLimit = CreditLimit;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getCardType() {
        return cardType;
    }

    public int getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        CreditLimit = creditLimit;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo='" + cardNo + '\'' +
                ", holderName='" + holderName + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                ", gatewayName='" + gatewayName + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}

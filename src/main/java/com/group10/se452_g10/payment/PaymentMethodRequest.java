package com.group10.se452_g10.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.NonNull;

import java.time.LocalDate;

public class PaymentMethodRequest {

    private Long studentId;


    public PaymentMethodRequest(Long studentId, LocalDate date, Float amount, String typeOfMethod, String transactionId) {
        this.studentId = studentId;
        this.date = date;
        this.amount = amount;
        this.TypeOfMethod = typeOfMethod;
        this.transactionId = transactionId;
    }

    public PaymentMethodRequest(){

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getTypeOfMethod() {
        return TypeOfMethod;
    }

    public void setTypeOfMethod(String typeOfMethod) {
        TypeOfMethod = typeOfMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    private LocalDate date;


    private Float amount;


    private String TypeOfMethod;


    private String transactionId;
}

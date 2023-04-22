package com.group10.se452_g10.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_method", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"stu_id", "trans_id"})
})
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stu_id", nullable = false, unique = true)
    @NonNull
    private Long studentId;


    @NonNull
    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @NonNull
    @Column(name = "amount", nullable = false)
    private Float amount;

    @NonNull
//    @Enumerated(EnumType.ORDINAL)
    @Column(name = "method", nullable = false)
    private String typeOfMethod;

    @NonNull
    @Column(name = "trans_id", nullable = false, unique = true)
    private String transactionId;


    private String remarks;

    public PaymentMethod(PaymentMethodRequest paymentMethodRequest){

        this.studentId = paymentMethodRequest.getStudentId();
        this.amount = paymentMethodRequest.getAmount();
        this.typeOfMethod = paymentMethodRequest.getTypeOfMethod();
        this.transactionId = paymentMethodRequest.getTransactionId();
        this.date = LocalDate.now();
    }


//    public PaymentMethod(PaymentMethodRequest paymentMethodRequest){
//
//        this.studentId = Long.valueOf(121212);
//        this.amount = Float.valueOf(232323);
//        this.typeOfMethod = "cc";
//        this.transactionId = "sdn";
//        this.date = LocalDate.now();
//    }


}

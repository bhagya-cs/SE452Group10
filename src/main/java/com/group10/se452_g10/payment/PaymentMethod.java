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

    @Column(name = "stu_id")
    @NonNull
    private Long studentId;


    @NonNull
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @NonNull
    @Column(name = "amount")
    private Float amount;

    @NonNull
//    @Enumerated(EnumType.ORDINAL)
    @Column(name = "method")
    private String TypeOfMethod;

    @NonNull
    @Column(name = "trans_id")
    private String transactionId;


    private String remarks;


}

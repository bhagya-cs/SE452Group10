package com.group10.se452_g10.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_record", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"course_id"})
})
public class PaymentRecord {

    @Id
    @NonNull
    @Column(name = "course_id")
    private Long courseId;

    @NonNull
    @Column(name = "course_fee")
    private Float courseFee;

}

package com.group10.se452_g10.payment;

import com.group10.se452_g10.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_record")
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long table_id;


    @OneToOne
    @JoinColumn(name = "num",nullable = false,unique = true)
    private Course courseId;

    @NonNull
    @Column(name = "course_fee",nullable = false)
    private Float courseFee;

}

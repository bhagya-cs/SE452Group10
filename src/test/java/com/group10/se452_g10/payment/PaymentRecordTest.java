package com.group10.se452_g10.payment;

import org.aspectj.lang.annotation.Before;
import org.hibernate.NonUniqueObjectException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class PaymentRecordTest {


    @Autowired
    private PaymentRecordRepository repository;



    @Before("")
    public void setup() {
        // Perform setup tasks here


    }

    @Test
    public void testCreationPaymentRecord() {

        PaymentRecord paymentRecord = new PaymentRecord(234L, 5678F);
        long beforeCount = repository.count();
        PaymentRecord paymentRecord1 = repository.save(paymentRecord);
        assertNotNull(paymentRecord1.getCourseId());
        var afterCount = repository.count();
        assertEquals(beforeCount + 1, afterCount);

    }

    @Test
    public void testPaymentRecordCreationWithNullValues() {
        try {
            PaymentRecord paymentRecord = new PaymentRecord(null, 12F);
        } catch (NullPointerException e) {
            // expected exception was thrown, test passed
            assertEquals("courseId is marked non-null but is null", e.getMessage());
        }
    }


    @Test
    public void testDeletePaymentRecord() {

        PaymentRecord paymentRecord = new PaymentRecord(234L, 5678F);
        PaymentRecord savedPaymentMethod = repository.save(paymentRecord);

        long count1 = repository.count();
        repository.delete(paymentRecord);

        long count2 = repository.count();
        assertEquals(count1 - 1, count2);

        PaymentRecord paymentRecord1 = new PaymentRecord(23234L, 63834F);
        PaymentRecord savedPaymentMethod1 = repository.save(paymentRecord1);

        long count3 = repository.count();
        assertEquals(count2 + 1, count3);

        PaymentRecord savedPaymentMethod2 = repository.save(paymentRecord);
        long count4 = repository.count();

        assertEquals(count3 + 1, count4);

        repository.deleteAll();

        long count5 = repository.count();
        assertEquals(count5, 0);

    }

    @Test
    public void testReadPaymentRecord() {

        PaymentRecord paymentRecord = new PaymentRecord(234L, 5678F);
        PaymentRecord savedPaymentMethod = repository.save(paymentRecord);

        Optional<PaymentRecord> verifiedPayment = repository.findById(paymentRecord.getCourseId());

        assertEquals(savedPaymentMethod.getCourseId(), verifiedPayment.get().getCourseId());
        assertEquals(savedPaymentMethod.getCourseFee(), paymentRecord.getCourseFee());

    }



    @Test
    public void testUpdatePaymentRecord() {
        PaymentRecord paymentRecord = new PaymentRecord();
        paymentRecord.setCourseId(1L);
        paymentRecord.setCourseFee(100.0f);

        PaymentRecord savedCourse = repository.save(paymentRecord);
        Long savedCourseId = savedCourse.getCourseId();

        PaymentRecord paymentRecord1 = new PaymentRecord();
        paymentRecord1.setCourseId(savedCourseId);
        paymentRecord1.setCourseFee(200.0f);
        Float updatedCourseFee = 200.0f;
        PaymentRecord updatedSave = repository.save(paymentRecord1);
        assertNotNull(updatedSave);
        assertEquals(savedCourseId, updatedSave.getCourseId());
        assertEquals(updatedCourseFee, updatedSave.getCourseFee());
    }


}

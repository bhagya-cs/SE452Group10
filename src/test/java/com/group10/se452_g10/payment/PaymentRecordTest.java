package com.group10.se452_g10.payment;

import com.group10.se452_g10.account.Student;
import com.group10.se452_g10.course.Course;
import com.group10.se452_g10.course.CourseRepository;
import org.aspectj.lang.annotation.Before;
import org.hibernate.NonUniqueObjectException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class PaymentRecordTest {


    @Autowired
    private PaymentRecordRepository repository;

    @Autowired
    private CourseRepository courseRepository;



    @Before("")
    public void setup() {
        // Perform setup tasks here


    }

    @Test
    public void testCreationPaymentRecord() {
//        Course course = new Course(1L,"cs","1","se");
//        courseRepository.save(course);


        PaymentRecord paymentRecord = new PaymentRecord(1L, 5678F);
        long beforeCount = repository.count();
         repository.save(paymentRecord);

        PaymentRecord paymentRecord1 = repository.save(paymentRecord);
        assertNotNull(paymentRecord1.getTable_id());
        var afterCount = repository.count();
        assertEquals(beforeCount + 1, afterCount);

    }

    @Test
    public void testPaymentRecordCreationWithNullValues() {
        try {
            PaymentRecord paymentRecord = new PaymentRecord(1L,null);
        } catch (NullPointerException e) {
            // expected exception was thrown, test passed
            assertEquals("courseFee is marked non-null but is null", e.getMessage());
        }
    }


    @Test
    public void testDeletePaymentRecord() {
//        Course course = new Course(234L,"cs","1","se");
//
//        courseRepository.save(course);

        PaymentRecord paymentRecord = new PaymentRecord(1L, 5678F);
        PaymentRecord savedPaymentMethod = repository.save(paymentRecord);

        long count1 = repository.count();
        repository.delete(paymentRecord);

        long count2 = repository.count();
        assertEquals(count1 - 1, count2);
//        Course course1 = new Course(23234L,"cs","1","st");
//        courseRepository.save(course1);

        PaymentRecord paymentRecord1 = new PaymentRecord(2L, 63834F);
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

//        Course course1 = new Course(234L,"cs","1","se");
//
//        courseRepository.save(course1);
//        List<Course> courseList = courseRepository.findAll();
//
//        Course c1= courseList.get(0);

        PaymentRecord paymentRecord = new PaymentRecord(1L, 5678F);

        PaymentRecord savedPaymentMethod = repository.save(paymentRecord);



        Optional<PaymentRecord> verifiedPayment = repository.findById(paymentRecord.getTable_id());

        assertEquals(savedPaymentMethod.getTable_id(), verifiedPayment.get().getTable_id());
        assertEquals(savedPaymentMethod.getCourseFee(), paymentRecord.getCourseFee());

    }



    @Test
    public void testUpdatePaymentRecord() {
//
//        Course course1 = new Course(1L,"cs","1","se");
//
//        courseRepository.save(course1);
        PaymentRecord paymentRecord = new PaymentRecord(1L, 5678F);


        PaymentRecord savedCourse = repository.save(paymentRecord);
        Long savedTableId = savedCourse.getTable_id();
//        Course course2 = new Course(savedCourseId,"cs","1","se");


        PaymentRecord paymentRecord1 = new PaymentRecord();
        paymentRecord1.setTable_id(savedTableId);
//        paymentRecord1.setCourseId(savedCourseId);
        paymentRecord1.setCourseFee(200.0f);
        Float updatedCourseFee = 200.0f;
        PaymentRecord updatedSave = repository.save(paymentRecord1);
        assertNotNull(updatedSave);
        assertEquals(savedTableId, updatedSave.getTable_id());
        assertEquals(updatedCourseFee, updatedSave.getCourseFee());

    }


}

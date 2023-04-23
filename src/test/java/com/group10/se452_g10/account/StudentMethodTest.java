package com.group10.se452_g10.account;


import com.group10.se452_g10.payment.PaymentRecord;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class StudentMethodTest {

    private StudentRepo studentRepo;


    @Before("")
    public void setup() {
        // Perform setup tasks here

    }

    @Test
    public void testCreationStudent() {

        Student s_1 = new Student();
        Student s_2 = new Student();
        s_1.setAddress("Chicago");
        s_1.setFirstName("Ayyub");
        s_1.setLastName("Jose");
        s_1.setGender("M");

        s_2.setAddress("France");
        s_2.setFirstName("Grant");
        s_2.setLastName("Jone");
        s_2.setGender("M");


        long beforeCount = studentRepo.count();
        Student s1_test = studentRepo.save(s_1);
        Student s2_test = studentRepo.save(s_2);
        assertNotNull(s1_test.getGender());
        var afterCount = studentRepo.count();
        assertEquals(beforeCount + 1, afterCount);

    }


    @Test
    public void testDeleteStudentRecord() {

        Student s_1 = new Student();

        s_1.setAddress("Chicago");
        s_1.setFirstName("Ayyub");
        s_1.setLastName("Jose");
        s_1.setGender("M");


        Student s1_test = studentRepo.save(s_1);
        long count1 = studentRepo.count();
        studentRepo.delete(s1_test);
        long count2 = studentRepo.count();
        assertEquals(count1 - 1, count2);


        Student s_2 = new Student();
        s_2.setAddress("France");
        s_2.setFirstName("Grant");
        s_2.setLastName("Jone");
        s_2.setGender("M");


        Student s2_test = studentRepo.save(s_2);
        long count3 = studentRepo.count();
        studentRepo.delete(s2_test);
        assertEquals(count2 + 1, count3);


        long count4 = studentRepo.count();
        assertEquals(count3 + 1, count4);
        studentRepo.deleteAll();

        long count5 = studentRepo.count();
        assertEquals(count5, 0);

    }

    @Test
    public void testReadStudentRecord() {



    }
}


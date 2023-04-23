package com.group10.se452_g10.account;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class TeacherMethodTest {

    private TeacherRepo teacherRepo;


    @Before("")
    public void setup() {
        // Perform setup tasks here

    }

    @Test
    public void testCreationTeacher() {

        Teacher s_1 = new Teacher();
        Teacher s_2 = new Teacher();
        s_1.setAddress("Chicago");
        s_1.setFirstName("Ayyub");
        s_1.setLastName("Jose");
        s_1.setGender("M");

        s_2.setAddress("France");
        s_2.setFirstName("Jannine");
        s_2.setLastName("Jone");
        s_2.setGender("F");


        long beforeCount = teacherRepo.count();
        Teacher s1_test = teacherRepo.save(s_1);
        Teacher s2_test = teacherRepo.save(s_2);
        assertNotNull(s1_test.getGender());
        var afterCount = teacherRepo.count();
        assertEquals(beforeCount + 1, afterCount);

    }


    @Test
    public void testDeleteTeacherRecord() {

        Teacher s_1 = new Teacher();

        s_1.setAddress("Chicago");
        s_1.setFirstName("Ayyub");
        s_1.setLastName("Jose");
        s_1.setGender("M");


        Teacher s1_test = teacherRepo.save(s_1);
        long count1 = teacherRepo.count();
        teacherRepo.delete(s1_test);
        long count2 = teacherRepo.count();
        assertEquals(count1 - 1, count2);


        Teacher s_2 = new Teacher();
        s_2.setAddress("France");
        s_2.setFirstName("Grant");
        s_2.setLastName("Jone");
        s_2.setGender("M");


        Teacher s2_test = teacherRepo.save(s_2);
        long count3 = teacherRepo.count();
        teacherRepo.delete(s2_test);
        assertEquals(count2 + 1, count3);


        long count4 = teacherRepo.count();
        assertEquals(count3 + 1, count4);
        teacherRepo.deleteAll();

        long count5 = teacherRepo.count();
        assertEquals(count5, 0);


    }

    @Test
    public void testReadTeacherRecord() {


    }

}

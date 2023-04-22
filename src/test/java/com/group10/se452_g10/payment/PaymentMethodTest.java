package com.group10.se452_g10.payment;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
//@Sql({"/data-h2-test.sql"})
public class PaymentMethodTest {

    @Autowired
    private PaymentMethodRepository repository;

    @Before("")
    public void setup() {
        // Perform setup tasks here
    }


    @Test
    @Transactional
    public void testCreationPaymentMethod() {

        long beforeCount = repository.count();
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setStudentId(1L);
        paymentMethod.setDate(LocalDate.now());
        paymentMethod.setAmount(100.0f);
        paymentMethod.setTypeOfMethod(PaymentMethodType.CREDIT_CARD.getMethod());
        paymentMethod.setTransactionId("123456");
        paymentMethod.setRemarks("Test payment");
        PaymentMethod savedPaymentMethod = repository.save(paymentMethod);
        assertNotNull(savedPaymentMethod.getId());
        var afterCount = repository.count();
        assertEquals(beforeCount + 1, afterCount);

    }

    @Test
    public void testPaymentMethodCreationWithNullValues() {
        try {
            PaymentMethod paymentMethod = new PaymentMethod(null, null, null, null, null, null, null);
        } catch (NullPointerException e) {
            // expected exception was thrown, test passed
            assertEquals("studentId is marked non-null but is null", e.getMessage());
        }
    }


    @Test
    public void testDeletePaymentMethod(){

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setStudentId(1244L);
        paymentMethod.setDate(LocalDate.now());
        paymentMethod.setAmount(4500.0f);
        paymentMethod.setTypeOfMethod(PaymentMethodType.DEBIT_CARD.getMethod());
        paymentMethod.setTransactionId("adknf2324234");
        paymentMethod.setRemarks("Test payment");
        PaymentMethod savedPaymentMethod = repository.save(paymentMethod);

        long count1 = repository.count();
        repository.delete(paymentMethod);
        long count2 = repository.count();

        assertEquals(count1-1,count2);

        PaymentMethod paymentMethod1 = new PaymentMethod();
        paymentMethod1.setStudentId(1243334L);
        paymentMethod1.setDate(LocalDate.now());
        paymentMethod1.setAmount(4500.0f);
        paymentMethod1.setTypeOfMethod(PaymentMethodType.NET_BANKING.getMethod());
        paymentMethod1.setTransactionId("adknf232423422");
        paymentMethod1.setRemarks("Test payment");
        PaymentMethod savedPaymentMethod1 = repository.save(paymentMethod1);

        long count3 = repository.count();

        assertEquals(count2+1,count3);

        PaymentMethod savedPaymentMethod2 = repository.save(paymentMethod);

        long count4 = repository.count();

        assertEquals(count3+1,count4);

        repository.deleteAll();
        long count5 = repository.count();

        assertEquals(count5,0);

    }

    @Test
    public void testReadPaymentMethod(){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setStudentId(1244L);
        paymentMethod.setDate(LocalDate.now());
        paymentMethod.setAmount(4500.0f);
        paymentMethod.setTypeOfMethod(PaymentMethodType.DEBIT_CARD.getMethod());
        paymentMethod.setTransactionId("adknf2324234");
        paymentMethod.setRemarks("Test payment");

        PaymentMethod savedPaymentMethod = repository.save(paymentMethod);

        Optional<PaymentMethod> verifiedPayment =repository.findById(paymentMethod.getId());
        assertEquals(savedPaymentMethod.getId(),verifiedPayment.get().getId());
        assertEquals(savedPaymentMethod.getAmount(),paymentMethod.getAmount());
        assertEquals(savedPaymentMethod.getTransactionId(),paymentMethod.getTransactionId());

    }

    @Test
    public void testUniqueValuesVerification(){

        try {
            PaymentMethod paymentMethod = new PaymentMethod(null, 122L, LocalDate.now(), 8908F, "lk", "dhfjvjhkj987", null);
            PaymentMethod paymentMethod1 = new PaymentMethod(null, 122L, LocalDate.now(), 8908F, "lk", "dhfjvjhkj987", null);
            repository.save(paymentMethod);
            repository.save(paymentMethod1);
        } catch (Exception e) {
            // expected exception was thrown, test passed
            String str ="could not execute statement; SQL [n/a]; constraint ";
            assertEquals(str.substring(0,40), e.getMessage().substring(0,40),"Test Passed");
        }
    }

    @Test
    public void testUpdatePaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setStudentId(1L);
        paymentMethod.setDate(LocalDate.now());
        paymentMethod.setAmount(100.0f);
        paymentMethod.setTypeOfMethod("Credit Card");
        paymentMethod.setTransactionId("123456");
        paymentMethod.setRemarks("Test payment");

        PaymentMethod savedPaymentMethod = repository.save(paymentMethod);
        Long savedPaymentMethodId = savedPaymentMethod.getId();

        PaymentMethod updatedPaymentMethod = new PaymentMethod();
        updatedPaymentMethod.setId(savedPaymentMethodId);
        updatedPaymentMethod.setStudentId(2L);
        updatedPaymentMethod.setDate(LocalDate.now().plusDays(1));
        updatedPaymentMethod.setAmount(200.0f);
        updatedPaymentMethod.setTypeOfMethod("Debit Card");
        updatedPaymentMethod.setTransactionId("789012");
        updatedPaymentMethod.setRemarks("Updated payment");

        PaymentMethod updatedPaymentMethodResult = repository.save(updatedPaymentMethod);
        assertNotNull(updatedPaymentMethodResult);
        assertEquals(savedPaymentMethodId, updatedPaymentMethodResult.getId());
        assertEquals(updatedPaymentMethod.getStudentId(), updatedPaymentMethodResult.getStudentId());
        assertEquals(updatedPaymentMethod.getDate(), updatedPaymentMethodResult.getDate());
        assertEquals(updatedPaymentMethod.getAmount(), updatedPaymentMethodResult.getAmount());
        assertEquals(updatedPaymentMethod.getTypeOfMethod(), updatedPaymentMethodResult.getTypeOfMethod());
        assertEquals(updatedPaymentMethod.getTransactionId(), updatedPaymentMethodResult.getTransactionId());
        assertEquals(updatedPaymentMethod.getRemarks(), updatedPaymentMethodResult.getRemarks());
    }


}

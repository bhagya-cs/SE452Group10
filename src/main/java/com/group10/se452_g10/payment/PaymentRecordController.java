package com.group10.se452_g10.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_records")
public class PaymentRecordController {

    @Autowired
    private PaymentRecordRepository paymentRecordRepository;


    @GetMapping
    public List<PaymentRecord> getAllPayments(){

        return paymentRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentRecord> getPaymentMethodById(@PathVariable(value = "id") Long id) {
        PaymentRecord paymentRecord = paymentRecordRepository.findById(id)
                .orElseThrow(() -> new PaymentMethodController.Message("PaymentRecord not found for this id :: " + id));
        return ResponseEntity.ok().body(paymentRecord);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class Message extends RuntimeException{
        public Message(String s) {
            super(s);
        }
    }

    @PostMapping("/creates")
    public PaymentRecord createPayment(@RequestBody PaymentRecord paymentRecord) {
        // create a new payment using the data from the paymentRequest
//            PaymentRecord paymentRecord1 = new PaymentRecord(132L, 344F);
        PaymentRecord paymentRecord1 = new PaymentRecord(1L,paymentRecord.getCourseId(), paymentRecord.getCourseFee());

        // save the payment to the database
        paymentRecordRepository.save(paymentRecord1);
        // return the newly created payment object
        return paymentRecord1;
    }


}

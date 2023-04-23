package com.group10.se452_g10.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    @GetMapping
    public List<PaymentMethod> getAllPayments(){

        return paymentMethodRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable(value = "id") Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new Message("PaymentMethod not found for this id :: " + id));
        return ResponseEntity.ok().body(paymentMethod);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class Message extends RuntimeException{
        public Message(String s) {
            super(s);
        }
    }

    @PostMapping("/creates")
    public PaymentMethod createPayment(@RequestBody PaymentMethodRequest paymentMethodRequest) {
        // create a new payment using the data from the paymentRequest
        PaymentMethod payment = new PaymentMethod(paymentMethodRequest);
        // save the payment to the database
        paymentMethodRepository.save(payment);
        // return the newly created payment object
        return payment;


    }




}

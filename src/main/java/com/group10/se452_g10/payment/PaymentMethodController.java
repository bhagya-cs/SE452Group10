package com.group10.se452_g10.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "payment")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    public List<PaymentMethod> getAllPayments(){
        return paymentMethodRepository.findAll();
    }


}

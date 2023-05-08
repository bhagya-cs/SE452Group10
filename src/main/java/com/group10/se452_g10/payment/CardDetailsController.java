package com.group10.se452_g10.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card_details")
public class CardDetailsController {


    @Autowired
    private CardDetailsRepository cardDetailsRepository;


    @GetMapping
    public List<CardDetails> getAllCards(){

        return cardDetailsRepository.findAll();
    }

    @PostMapping("/creates")
    public CardDetails createCardDetail(@RequestBody CardDetails cardDetails) {
        // create a new payment using the data from the paymentRequest
        CardDetails cardDetails1 = new CardDetails();
        cardDetails1.setStudent(cardDetails.getStudent());
        cardDetails1.setType(cardDetails.getType());
        cardDetails1.setExpMonth(cardDetails.getExpMonth());
        cardDetails1.setNumber(cardDetails.getNumber());
        cardDetails1.setExpYear(cardDetails.getExpYear());


        // save the payment to the database
        cardDetailsRepository.save(cardDetails1);
        // return the newly created payment object
        return cardDetails1;

    }

    

}

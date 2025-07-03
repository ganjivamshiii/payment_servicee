package com.hulkhiretech.payments.controller;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hulkhiretech.payments.pojo.PaymentRequest;
import com.hulkhiretech.payments.pojo.PaymentResponse;
import com.hulkhiretech.payments.service.interfaces.PaymentService;
import com.hulkhiretech.payments.constant.Constant;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(Constant.PAYMENTS_ENDPOINT)
@Slf4j
public class PaymentController {
//  private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    
    
    // static final String PAYMENTS = "/payments";
    private PaymentService paymentService;  
    
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;  
    }
    
    @GetMapping
   
    public String getPayments() {
        return "Payments fetched";
    }

    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {  
        PaymentResponse response = paymentService.createPayment(paymentRequest);  
        return response;
    }
}


package com.example.hello.rabbit;

import com.example.hello.config.RabbitConfig;
import com.example.hello.model.response.PaymentDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitConfig.TO_PAYMENT_Q)
    public void listenPayment(PaymentDto paymentDto){
        System.out.println(paymentDto);
    }
}

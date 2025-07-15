package com.example.hello.rabbit;

import com.example.hello.config.RabbitConfig;
import com.example.hello.model.response.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendPayment(PaymentDto paymentDto){
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.ROUTING_KEY, paymentDto);
    }
}

package ru.eliseev.RabbitExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RabbitMqListener {
    //---2---free listeners process messages in sequence---2---

    /*@RabbitListener(queues = "myQueue")
    public void processMyQueue1(String message) {
        log.info("Received from myQueue 1 : {}", message);
    }

    @RabbitListener(queues = "myQueue")
    public void processMyQueue2(String message) {
        log.info("Received from myQueue 2 : {}", message);
    }*/

    //---2---free listeners process messages in sequence---2---

    @RabbitListener(queues = "myQueue")
    public void processMyQueue1(String message) {
        log.info("Received from myQueue 1 : {}", message);
    }

    @RabbitListener(queues = "myQueue2")
    public void processMyQueue2(String message) {
        log.info("Received from myQueue 2 : {}", message);
    }
}

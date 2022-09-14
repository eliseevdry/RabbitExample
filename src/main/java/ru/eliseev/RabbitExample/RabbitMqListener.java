package ru.eliseev.RabbitExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RabbitMqListener {
    @RabbitListener(queues = "myQueue")
    public void processMyQueue1(String message) {
        log.info("Received from myQueue 1 : {}", message);
    }

    @RabbitListener(queues = "myQueue")
    public void processMyQueue2(String message) {
        log.info("Received from myQueue 2 : {}", message);
    }
}

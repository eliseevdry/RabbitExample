package ru.eliseev.RabbitExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class SampleController {
    @Autowired
    private AmqpTemplate template;

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message) {
        log.info("Emit to myQueue");
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("myQueue", ThreadLocalRandom.current().nextInt());
        }
        return ResponseEntity.ok("Success emit to queue");
    }
}

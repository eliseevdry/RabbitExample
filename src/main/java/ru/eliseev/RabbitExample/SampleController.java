package ru.eliseev.RabbitExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class SampleController {
    //---1-2---

    /*@Autowired
    private AmqpTemplate template;*/

    //---1-2---

    @Autowired
    private RabbitTemplate template;

    //___4,5___

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody Map<String,String> map) {
        log.info("Emit to myQueue");
        template.setExchange("topic-exchange");
        template.convertAndSend(map.get("key"), map.get("message"));
        return ResponseEntity.ok("Success emit to queue");
    }

    //___4,5___

    //___3___

    /*@PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message) {
        log.info("Emit to myQueue");
        template.setExchange("common-exchange");
        template.convertAndSend(message);
        return ResponseEntity.ok("Success emit to queue");
    }*/

    //___3___

    //___1,2___

    /*@PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message) {
        log.info("Emit to myQueue");
        //template.setExchange("common-exchange");
        template.convertAndSend("myQueue", message);
        return ResponseEntity.ok("Success emit to queue");
    }*/

    //___1,2___
}

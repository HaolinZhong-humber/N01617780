package com.example.JmsApplication;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JmsProducerController {

    private final JmsTemplate jmsTemplate;

    public JmsProducerController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @GetMapping("/send")
    public String sendText(@RequestParam String message) {
        jmsTemplate.convertAndSend("demo-queue", message);
        return "Text message sent: " + message;
    }

    @PostMapping("/send-object")
    public String sendObject(@RequestBody MessageParser messageParser) {
        System.out.println(" POST /send-object hit with: " + messageParser);
        jmsTemplate.convertAndSend("object-queue", messageParser);
        return "Structured message sent: " + messageParser;
    }
}

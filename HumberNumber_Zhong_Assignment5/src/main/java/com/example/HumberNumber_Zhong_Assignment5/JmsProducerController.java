package com.example.HumberNumber_Zhong_Assignment5;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JmsProducerController {

    private final JmsTemplate jmsTemplate;

    public JmsProducerController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    // Text message - tutorial
    @GetMapping("/send")
    public String sendText(@RequestParam String message) {
        jmsTemplate.convertAndSend("demo-queue", message);
        return "Text message sent: " + message;
    }

    // Object message - assignment 5
    @PostMapping("/send-object")
    public String sendObject(@RequestBody MessageParser messageParser) {
        jmsTemplate.convertAndSend("object-queue", messageParser);
        return "Structured message sent: " + messageParser;
    }
}

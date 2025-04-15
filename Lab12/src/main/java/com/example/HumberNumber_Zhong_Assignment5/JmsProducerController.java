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

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        jmsTemplate.convertAndSend("demo-queue", message);
        return "Message sent: " + message;
    }
}

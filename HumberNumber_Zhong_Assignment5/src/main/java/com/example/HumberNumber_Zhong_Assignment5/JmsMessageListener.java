package com.example.HumberNumber_Zhong_Assignment5;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener {

    // Listen to object messages
    @JmsListener(destination = "object-queue")
    public void receiveObject(MessageParser messageParser) {
        System.out.println("Received Object:");
        System.out.println("Name: " + messageParser.getName());
        System.out.println("Message: " + messageParser.getMessage());
    }

    // Listen to plain text messages (optional)
    @JmsListener(destination = "demo-queue")
    public void receiveText(String message) {
        System.out.println("Received Text: " + message);
    }
}

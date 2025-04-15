package com.example.JmsApplication;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener {


    @JmsListener(destination = "demo-queue")
    public void receiveText(String message) {
        System.out.println("📩 Received TEXT: " + message);
    }


    @JmsListener(destination = "object-queue")
    public void receiveObject(MessageParser messageParser) {
        System.out.println("📦 Received OBJECT:");
        System.out.println("Name: " + messageParser.getName());
        System.out.println("Message: " + messageParser.getMessage());
    }
}

package com.example.JmsApplication;

import java.io.Serializable;

public class MessageParser implements Serializable {
    private String name;
    private String message;

    public MessageParser() {}

    public MessageParser(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageParser{name='" + name + "', message='" + message + "'}";
    }
}

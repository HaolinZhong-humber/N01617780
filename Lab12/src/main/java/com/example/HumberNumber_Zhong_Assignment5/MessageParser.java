package com.example.HumberNumber_Zhong_Assignment5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageParser implements Serializable {
    private String name;
    private String message;
}

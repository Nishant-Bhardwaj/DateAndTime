package com.java8.datetime.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String hello(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello";
    }

    public String world(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return " World!!";
    }
}

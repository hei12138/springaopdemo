package com.hei123.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SseController {
    @RequestMapping(value = "/push",produces = "text/event-stream")
    public String push(){
        Random random = new Random();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:test 1,2,3"+ random.nextInt()+"\n\n";
    }
}

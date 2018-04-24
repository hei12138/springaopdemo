package com.hei123.demo.service;

import com.hei123.demo.annotation.NeedServer;

public class Player {

    @NeedServer
    public void playGame(){
        System.out.println("i am play game");
    }

    public void playBasketBall(){
        System.out.println("i am play basketball");
    }
}

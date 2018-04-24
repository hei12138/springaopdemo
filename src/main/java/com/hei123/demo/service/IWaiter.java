package com.hei123.demo.service;

public interface IWaiter {
    void greetTo(String name);

    int greetTo(String name, String name2);

    void serveTo(String name);

    void breakTeaCup(String name) throws Exception;
}

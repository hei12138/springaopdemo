package com.hei123.demo.service.impl;

import com.hei123.demo.service.IWaiter;

public class WaiterImpl2 implements IWaiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greetTo2");
    }

    @Override
    public int greetTo(String name, String name2) {
        System.out.println("greetTo2"+name+" and "+name2);
        return 0;
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serveTo2");
    }

    @Override
    public void breakTeaCup(String name) throws Exception {
        System.out.println("test");
    }
}

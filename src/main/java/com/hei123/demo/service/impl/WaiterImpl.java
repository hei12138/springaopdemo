package com.hei123.demo.service.impl;

import com.hei123.demo.service.IWaiter;

public class WaiterImpl implements IWaiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    @Override
    public int greetTo(String name, String name2) {
        System.out.println("greet to "+name+" and "+name2);
        return 0;
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to "+name+"...");
    }

    @Override
    public void breakTeaCup(String name) throws Exception {
        System.out.println("在服务的过程中摔碎了杯子");
        throw new Exception("异常：摔碎了杯子");
    }

}

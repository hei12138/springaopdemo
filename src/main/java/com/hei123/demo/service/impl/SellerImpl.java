package com.hei123.demo.service.impl;

import com.hei123.demo.service.ISeller;

public class SellerImpl implements ISeller {
    @Override
    public void greetTo(String name) {
        System.out.println("seller greet to" +name+"...");
    }
}

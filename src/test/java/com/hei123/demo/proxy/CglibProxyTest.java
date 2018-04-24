package com.hei123.demo.proxy;

import com.hei123.demo.service.impl.ForumServiceImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class CglibProxyTest {
    @Test
    public void cglibProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        Object o = cglibProxy.getProxy(ForumServiceImpl.class);
        System.out.println(o.getClass().getName());
        ForumServiceImpl proxy = (ForumServiceImpl)o;
        proxy.removeForum(10);
        proxy.removeTopic(1023);
    }
}
package com.hei123.demo.aspect;

import com.hei123.demo.service.IWaiter;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class InfoAspectTest {

    @Test
    public void test(){
        String configPath= "aop/aspect/aspect-info.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        waiter.greetTo("tom");
        waiter.greetTo("hanmeimei","lilei");
        try {
            waiter.breakTeaCup("fall");
        } catch (Exception e) {

        }
    }
}
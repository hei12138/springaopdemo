package com.hei123.demo.aspect;

import com.hei123.demo.service.IWaiter;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class pointCutAspectTest {

    @Test
    public void test(){
        String configPath= "aop/aspect/aspect-pointcut.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        waiter.greetTo("tom");
        waiter.serveTo("tom");
    }
}
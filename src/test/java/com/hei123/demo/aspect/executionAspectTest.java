package com.hei123.demo.aspect;

import com.hei123.demo.service.IWaiter;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class executionAspectTest {

    @Test
    public void test(){
        String configPath= "aop/aspect/aspect-execution.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        waiter.greetTo("john");
        System.out.println("------------------");
        waiter.serveTo("hanmeimei");
        System.out.println("------------------");
        try {
            waiter.breakTeaCup("lilei");
        } catch (Exception e) {

        }
        waiter.greetTo("我","你");

    }

}
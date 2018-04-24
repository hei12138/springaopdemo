package com.hei123.demo.aspect;

import com.hei123.demo.service.IWaiter;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TargetAspectTest {

    @Test
    public void test(){
        String configPath= "aop/aspect/aspect-target.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        IWaiter waiter2 = (IWaiter) ctx.getBean("waiter2");
        waiter.serveTo("tom");
        waiter2.serveTo("tom");
    }

}
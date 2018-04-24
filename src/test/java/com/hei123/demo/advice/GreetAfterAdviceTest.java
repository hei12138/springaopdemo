package com.hei123.demo.advice;

import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class GreetAfterAdviceTest {
    @Test
    public void test(){
        WaiterImpl target = new WaiterImpl();
        GreetAfterAdvice advice = new GreetAfterAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);
        IWaiter proxy = (IWaiter) proxyFactory.getProxy();
        proxy.greetTo("john");
        proxy.serveTo("tom");
    }

    @Test
    public void testXml(){
        String configPath="aop/advice/advice-after.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiterProxy = (IWaiter) ctx.getBean("waiterProxy");
        System.out.println(waiterProxy.getClass());
        waiterProxy.greetTo("john");
        waiterProxy.greetTo("tom");
    }

}
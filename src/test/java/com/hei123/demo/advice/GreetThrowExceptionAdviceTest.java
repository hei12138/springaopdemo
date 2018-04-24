package com.hei123.demo.advice;

import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetThrowExceptionAdviceTest {
    @Test
    public void test(){
        WaiterImpl target = new WaiterImpl();
        GreetThrowExceptionAdvice greetThrowExceptionAdvice = new GreetThrowExceptionAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(greetThrowExceptionAdvice);
        IWaiter proxy = (IWaiter) proxyFactory.getProxy();
        proxy.greetTo("john");
        proxy.serveTo("tom");
    }

    @Test
    public void testXml(){
        String configPath="aop/advice/advice-throwException.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiterProxy = (IWaiter) ctx.getBean("forumServiceProxy");
        System.out.println(waiterProxy.getClass());
        waiterProxy.greetTo("john");
        waiterProxy.greetTo("tom");
    }

}
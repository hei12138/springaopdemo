package com.hei123.demo.advice;

import com.hei123.demo.service.IForumService;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class GreetInterceptorTest {
    @Test
    public void test(){
        WaiterImpl target = new WaiterImpl();
        GreetInterceptor greetInterceptor = new GreetInterceptor();
        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(greetInterceptor);
        IForumService proxy = (IForumService) proxyFactory.getProxy();
        proxy.removeForum(10);
    }
    @Test
    public void testXml(){
        String configPath="aop/advice/advice-interceptor.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IForumService forumProxy = (IForumService) ctx.getBean("waiterProxy");
        System.out.println(forumProxy.getClass());
        forumProxy.removeForum(10);
    }
}
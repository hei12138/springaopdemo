package com.hei123.demo.advisor;

import com.hei123.demo.advice.GreetBeforeAdvice;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.SellerImpl;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class GreetingStaticMethodMatcherAdvisorTest {
    @Test
    public void testWithJava(){
        WaiterImpl target = new WaiterImpl();
        GreetBeforeAdvice greetBeforeAdvice = new GreetBeforeAdvice();
        GreetingStaticMethodMatcherAdvisor advisor = new GreetingStaticMethodMatcherAdvisor();
        advisor.setAdvice(greetBeforeAdvice);
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        IWaiter proxy = (IWaiter) proxyFactory.getProxy();
        proxy.greetTo("john");
        proxy.serveTo("tom");
    }

    @Test
    public void testWithXml(){
        String configPath="aop/advisor/advisor-staticMethod.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        WaiterImpl waiter = (WaiterImpl) ctx.getBean("waiter");
        SellerImpl seller = (SellerImpl) ctx.getBean("seller");
        waiter.greetTo("john");
        waiter.serveTo("john");
        seller.greetTo("john");
    }

}
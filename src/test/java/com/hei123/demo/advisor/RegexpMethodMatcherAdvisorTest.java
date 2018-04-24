package com.hei123.demo.advisor;

import com.hei123.demo.advice.GreetBeforeAdvice;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.SellerImpl;
import com.hei123.demo.service.impl.WaiterImpl;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegexpMethodMatcherAdvisorTest {

    @Test
    public void testWithXml(){
        String configPath="aop/advisor/advisor-regexpMethod.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        WaiterImpl waiter = (WaiterImpl) ctx.getBean("waiter");
        waiter.greetTo("john");
        waiter.serveTo("john");
    }

}
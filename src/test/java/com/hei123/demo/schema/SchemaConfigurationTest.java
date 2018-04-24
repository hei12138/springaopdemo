package com.hei123.demo.schema;

import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.Player;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaConfigurationTest {
    @Test
    public void test(){
        String configPath= "aop/schema/applicationContext-aop.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        waiter.greetTo("Tom");
    }
}

package com.hei123.demo.advice;

import com.hei123.demo.service.IForumService;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.Monitorable;
import com.hei123.demo.service.impl.ForumServiceImpl;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ControllablePerformanceMonitorTest {
    @Test
    public void test(){
        ForumServiceImpl forumService = new ForumServiceImpl();
        ControllablePerformanceMonitor controllablePerformanceMonitor = new ControllablePerformanceMonitor();
        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setTarget(forumService);
        proxyFactory.addAdvice(controllablePerformanceMonitor);
        IForumService proxy = (IForumService) proxyFactory.getProxy();
        Monitorable monitorable = (Monitorable) proxy;
        monitorable.setMonitorAdvice(true);
        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }

    @Test
    public void testXml(){
        String configPath="aop/advice/advice-delegatingIntroductionInterceptor.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IForumService proxy = (IForumService) ctx.getBean("proxyForumService");
        System.out.println(proxy.getClass());
        Monitorable monitorable = (Monitorable) proxy;
        monitorable.setMonitorAdvice(true);
        proxy.removeForum(10);
        proxy.removeTopic(1022);

    }
}
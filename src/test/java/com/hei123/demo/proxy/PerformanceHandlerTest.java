package com.hei123.demo.proxy;

import com.hei123.demo.service.IForumService;
import com.hei123.demo.service.impl.ForumServiceImpl;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class PerformanceHandlerTest {
    @Test
    public void proxy(){
        IForumService target = new ForumServiceImpl();
        PerformanceHandler performanceHandler = new PerformanceHandler(target);
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), performanceHandler);
        System.out.println(o.getClass().getName());
        IForumService proxy = (IForumService) o;
        proxy.removeTopic(10);
        proxy.removeForum(1012);
    }

}
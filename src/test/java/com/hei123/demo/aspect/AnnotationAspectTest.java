package com.hei123.demo.aspect;

import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.Player;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AnnotationAspectTest {

    @Test
    public void test(){
        String configPath= "aop/aspect/aspect-annotation.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Player player = (Player) ctx.getBean("player");
        player.playGame();
    }

}
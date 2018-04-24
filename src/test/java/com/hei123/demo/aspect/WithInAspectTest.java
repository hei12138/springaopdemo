package com.hei123.demo.aspect;

import com.hei123.demo.service.Player;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class WithInAspectTest {
    @Test
    public void test(){
        String configPath= "aop/aspect/aspect-within.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Player player = (Player) ctx.getBean("player");
        player.playGame();
        player.playBasketBall();
    }

}
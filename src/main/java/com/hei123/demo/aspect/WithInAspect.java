package com.hei123.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class WithInAspect {
    /**
     * 匹配类中的所有方法 最小颗粒度为类
     */
    @Before("within(com.hei123.demo.service.Player)")
    public void withAspect(){
        System.out.println("基于@Aspect注解的within使用方式");
    }
}

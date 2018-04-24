package com.hei123.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TargetAspect {
    @Before("target(com.hei123.demo.service.IWaiter)")
    public void targetAspect(){
        System.out.println("基于@Aspect注解的target使用方式");
    }
}

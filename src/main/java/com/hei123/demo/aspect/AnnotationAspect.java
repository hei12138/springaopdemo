package com.hei123.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class AnnotationAspect {

    @Before("@annotation(com.hei123.demo.annotation.NeedServer)")
    public void before(){
        System.out.println("基于@Aspect的注解@annotation注解类增强");
    }
}

package com.hei123.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class pointCutAspect {
    @Pointcut("execution(* greetTo(..))")
    private void test(){}

    @Pointcut("execution(* serveTo(..))")
    private void test2(){}

    @Before("test()||"+"test2()")
    private void pointCutAspect(){
        System.out.println("基于@Aspect注解的pointCut用法");
    }
}

package com.hei123.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class ExecutionAspect {

    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("基于@Aspect注解的AOP前置增强");
    }

    //参数名只能应用在target注解、this、args注解


    @AfterReturning("execution(* greetTo(..))")
    public void after() {
        System.out.println("基于@Aspect注解的AOP后置增强");
    }

    @AfterThrowing("execution(* breakTeaCup(..))")
    public void throwException() {
        System.out.println("基于@Aspect注解的AOP异常增强");

    }

    @Around("execution(* serveTo(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("基于@Aspect注解的AOP环绕增强----before");
        pjp.proceed();
        System.out.println("基于@Aspect注解的AOP环绕增强----after");
    }


    /**
     * 获取参数名
     * @param a1
     * @param b2
     */
    @After(value = "execution(* greetTo(..)) && args(a1,b2)", argNames = "a1,b2")
    public void finalAdvice(String a1, String b2) {
        System.out.println("基于@Aspect注解的AOP Final增强"+a1+b2);
    }
}

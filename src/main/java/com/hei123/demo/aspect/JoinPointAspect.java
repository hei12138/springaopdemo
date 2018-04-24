package com.hei123.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class JoinPointAspect {

    @Pointcut("execution(* greetTo(..))")
    public void declareJoinPointerExpression() {}

    /**
     * 前置方法,在目标方法执行前执行
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @Before("declareJoinPointerExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("基于@Aspect注解的获取连接点信息");
        System.out.println(joinPoint.getArgs().toString());
    }


    @Around("execution(* serveTo(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("基于@Aspect注解的AOP环绕增强----before");
        pjp.proceed();
        System.out.println("基于@Aspect注解的AOP环绕增强----after");
    }
}

package com.hei123.demo.aspect;

import com.hei123.demo.service.IWaiter;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class InfoAspect {
    /**
     * 获取参数名
     * @param a1
     * @param b2
     */
    @Before(value = "execution(* greetTo(..)) && args(a1,b2)", argNames = "a1,b2")
    public void finalAdvice(String a1, String b2) {
        System.out.println("基于@Aspect注解的绑定连接点参数"+a1+b2);
    }

    @Before("this(waiter)")
    public void bindProxyObj(IWaiter waiter){
        System.out.println("基于@Aspect注解的绑定代理对象");
        System.out.println(waiter.getClass().getName());
    }

    @AfterReturning(value = "execution(* greetTo(String,String))",returning = "returnValue")
    public void bindReturnValue(int returnValue){
        System.out.println("基于@Aspect注解的绑定返回值");
        System.out.println(returnValue);
    }

    @AfterThrowing(value = "execution(* breakTeaCup(..))",throwing = "e")
    public void bindException(Exception e){
        System.out.println("基于@Aspect注解的绑定抛出异常");
        System.out.println(e.getMessage());
    }
}

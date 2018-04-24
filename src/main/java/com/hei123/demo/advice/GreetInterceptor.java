package com.hei123.demo.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class GreetInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        String clientName = (String) arguments[0];
        System.out.println("how are you");
        Object obj = methodInvocation.proceed();
        System.out.println("enjoy yourself");
        return obj;
    }
}

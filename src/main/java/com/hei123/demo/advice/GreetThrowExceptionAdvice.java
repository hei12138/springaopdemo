package com.hei123.demo.advice;


import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Objects;

public class GreetThrowExceptionAdvice implements ThrowsAdvice {

    /**
     * 该接口下未定义任何方法 标签接口 通过反射机制判断出符合条件的方法进行调用
     * 方法名必须未afterThrowing
     * 前三个参要么全部有，要么一个都没有(即只剩ex一个参数)
     * @param method 抛出异常的方法名
     * @param args 抛出异常的方法的参数
     * @param target
     * @param ex
     * @throws Throwable
     */
    public void afterThrowing(Method method, Objects[] args,Object target,Exception ex) throws Throwable{
        System.out.println("----------");
        System.out.println("method:"+method.getName());
        System.out.println("抛出异常:"+ex.getMessage());
        System.out.println("由异常抛出增强处理");
    }

}

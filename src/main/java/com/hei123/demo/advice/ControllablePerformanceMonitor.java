package com.hei123.demo.advice;

import com.hei123.demo.monitor.PerformanceMonitor;
import com.hei123.demo.service.Monitorable;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介增强
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> monitorStatusMap=new ThreadLocal<>();

    @Override
    public void setMonitorAdvice(boolean active) {
        monitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj=null;
        if(monitorStatusMap.get()!=null&&monitorStatusMap.get()){
            PerformanceMonitor.begin(mi.getClass().getName()+"."+mi.getMethod().getName());
            obj=super.invoke(mi);
            PerformanceMonitor.end();
        }else{
            obj=super.invoke(mi);
        }
        return obj;
    }
}

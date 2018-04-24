package demo;

import com.hei123.demo.aspect.ExecutionAspect;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest {
    @Test
    public void test(){
        IWaiter waiter = new WaiterImpl();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        aspectJProxyFactory.setTarget(waiter);
        aspectJProxyFactory.addAspect(ExecutionAspect.class);
        IWaiter proxy = aspectJProxyFactory.getProxy();
        proxy.greetTo("john");
    }
}

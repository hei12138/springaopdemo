package demo;

import com.hei123.demo.advice.GreetBeforeAdvice;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.WaiterImpl;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticMethodAdvisorTest {
    @Test
    public void test(){
        WaiterImpl target = new WaiterImpl();
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("/aop/applicationContest-aop.xml");
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        waiter.greetTo("john");
        waiter.serveTo("tom");
    }
}

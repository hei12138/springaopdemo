package demo;

import com.hei123.demo.service.Monitorable;
import com.hei123.demo.service.IWaiter;
import com.hei123.demo.service.impl.ForumServiceImpl;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestForumService {
    public static void main(String[] args){
        ForumServiceImpl forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }

    @Test
    public void test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/schema/applicationContext-aop.xml");
        IWaiter waiter = (IWaiter) ctx.getBean("waiter");
        waiter.greetTo("john");
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/schema/applicationContext-aop.xml");

        ForumServiceImpl forumService = (ForumServiceImpl) ctx.getBean("forumService");
        Monitorable monitorable = (Monitorable) forumService;

        monitorable.setMonitorAdvice(true);

        forumService.removeForum(10);


    }
}

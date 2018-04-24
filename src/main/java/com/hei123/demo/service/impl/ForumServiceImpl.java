package com.hei123.demo.service.impl;

import com.hei123.demo.monitor.PerformanceMonitor;
import com.hei123.demo.service.IForumService;

import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl implements IForumService {
    @Override
    public void removeTopic(int topicId){
        System.out.println("模拟删除记录："+topicId);
        try {
            Thread.sleep(20);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void removeForum(int forumId){
        System.out.println("模拟删除记录："+forumId);
        try {
            Thread.sleep(40);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package com.hei123.demo.controller;

import com.hei123.demo.dto.DemoObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/index")
    @ResponseBody
    public DemoObject hello(){
        DemoObject demoObject = new DemoObject();
        demoObject.setId(123L);
        demoObject.setName("测试");
        return demoObject;
    }
}

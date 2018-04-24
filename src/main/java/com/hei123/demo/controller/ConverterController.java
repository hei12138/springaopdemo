package com.hei123.demo.controller;

import com.hei123.demo.dto.DemoObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {
    @RequestMapping("/convert")
    public DemoObject convert(DemoObject demoObject){
        return demoObject;
    }
}

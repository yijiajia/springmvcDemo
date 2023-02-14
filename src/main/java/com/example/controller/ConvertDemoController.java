package com.example.controller;

import com.example.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConvertDemoController {

    @RequestMapping(value = "/convert")
    public DemoObj convert(@RequestBody DemoObj demoObj) {
        System.out.println("请求demo转换器");
        return demoObj;
    }
}

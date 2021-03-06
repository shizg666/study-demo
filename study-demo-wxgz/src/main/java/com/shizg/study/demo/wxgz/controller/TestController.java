package com.shizg.study.demo.wxgz.controller;

import com.shizg.study.demo.autoload.HelloService;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description: TODO
 * @Author shizg
 * @Date 2020/12/24
 * @Version V1.0
 **/
@RestController
@RequestMapping("/aaa")
public class TestController {

    @Autowired
    private TPaMessageService service;
    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/test")
    public String test(){
        return helloService.say();
    }

    @GetMapping(value = "/error")
    public String error(){
        return "error";
    }

}

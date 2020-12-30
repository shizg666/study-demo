package com.shizg.study.demo.wxgz.controller;

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

    @GetMapping(value = "/test")
    public String test(){
        return "123";
    }

    @GetMapping(value = "/error")
    public String error(){
        return "error";
    }

}

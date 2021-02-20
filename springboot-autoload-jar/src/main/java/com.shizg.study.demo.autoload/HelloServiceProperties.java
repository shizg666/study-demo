package com.shizg.study.demo.autoload;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloServiceProperties
 * @Description: TODO
 * @Author shizg
 * @Date 2021/2/20
 * @Version V1.0
 **/

@ConfigurationProperties(prefix = "hello")
@Component
public class HelloServiceProperties {
    public static final String MSG = "hello";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

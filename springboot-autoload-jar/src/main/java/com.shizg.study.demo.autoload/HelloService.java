package com.shizg.study.demo.autoload;

/**
 * @ClassName HelloService
 * @Description: TODO
 * @Author shizg
 * @Date 2021/2/20
 * @Version V1.0
 **/
public class HelloService {
    private String msg ;
    public String say(){
        return msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

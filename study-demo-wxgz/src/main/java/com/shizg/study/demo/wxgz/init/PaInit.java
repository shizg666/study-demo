package com.shizg.study.demo.wxgz.init;

import com.shizg.study.demo.wxgz.handler.MessageHold;
import com.shizg.study.demo.wxgz.service.TPaMessageService;
import com.shizg.study.demo.wxgz.webmagic.GuoNIanReptile;
import com.shizg.study.demo.wxgz.webmagic.HearReptile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动加载行政区缓存
 */
@Component
@Slf4j
public class PaInit implements CommandLineRunner {

    @Autowired
    private HearReptile hearReptile;

    @Autowired
    private GuoNIanReptile guoNIanReptile;
    @Autowired
    private MessageHold messageHold;


    @Override
    public void run(String... args) throws Exception {
        messageHold.init();
//        hearReptile.start();
//        guoNIanReptile.start();
    }



}





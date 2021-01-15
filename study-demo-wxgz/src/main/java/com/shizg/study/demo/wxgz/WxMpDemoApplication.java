package com.shizg.study.demo.wxgz;

import com.shizg.study.demo.wxgz.webmagic.HearReptile;
import com.shizg.study.demo.wxgz.webmagic.MysqlPipeline;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.shizg.study.demo.**.mapper")
@ComponentScan("com.shizg.study.demo.*")
@EnableScheduling
@EnableAsync
@Slf4j
public class WxMpDemoApplication {
    public static final String FIRST_URL2 = "https://www.diyijuzi.com/aiqing/44264.html";
    public static void main(String[] args) {
        SpringApplication.run(WxMpDemoApplication.class, args);

    }
}

package com.shizg.study.demo.wxgz;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@SpringBootApplication(scanBasePackages = "com.shizg.study.demo.*")
@EnableConfigurationProperties
//@MapperScan("com.shizg.smartme.**.mapper")
@EnableScheduling
@EnableAsync
@Slf4j
public class WxMpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxMpDemoApplication.class, args);
    }
}

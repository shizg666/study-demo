package com.shizg.study.demo.design.g_eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

/**
 * google guava 工具包中的eventbus 配置类
 */
@Configuration
public class EventBusConfig {

    @Resource
    private ThreadPoolTaskExecutor eventBusPool;


    @Bean(name = "asyncEventBus")
    public AsyncEventBus asyncEventBus(){
        AsyncEventBus asyncEventBus = new AsyncEventBus("Async", eventBusPool);
        return asyncEventBus;
    }

}

package com.shizg.study.demo.design.g_eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName EnergyDataShowListener
 * @Description: 事件监听器
 * @Author shizg
 * @Date 2021/1/21
 * @Version V1.0
 **/
@Slf4j
@Component
public class EnergyDataShowListener {

    @Autowired
    private EventService eventService;
    @Autowired
    AsyncEventBus asyncEventBus;

    @Subscribe
    public void energyDataShowEvent(EnergyDataShowEvent event) {
        if (event.getRetryCount() >3){
            log.error("energyDataShowEvent -------------->发了3次依然报错！！！！！！！");
            return;
        }
        event.setRetryCount(event.getRetryCount()+1);
        try{
            eventService.say();
        }catch (Exception e){
            log.error("energyDataShowEvent -------------->报错:{}",e.getMessage());
            asyncEventBus.post(event);
        }

    }
}

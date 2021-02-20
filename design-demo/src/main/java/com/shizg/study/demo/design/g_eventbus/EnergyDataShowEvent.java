package com.shizg.study.demo.design.g_eventbus;

import lombok.Data;

/**
 * @ClassName EnergyDataShowEvent
 * @Description: TODO
 * @Author shizg
 * @Date 2021/1/21
 * @Version V1.0
 **/
@Data
public class EnergyDataShowEvent {
    private int retryCount;
    public EnergyDataShowEvent(int retryCount) {
        this.retryCount = retryCount;
    }

}

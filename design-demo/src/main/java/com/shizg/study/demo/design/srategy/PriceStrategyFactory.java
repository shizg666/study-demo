package com.shizg.study.demo.design.srategy;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 使用策略模式去除if else 判断简化代码
 * 第一种 dataMap 注册 Map<String, PriceStrategy> priceStrategyMap SpringBoot中 使用@Autowired 将bean注入到List或Map等集合中 在策略类使用自定义注解配置相关信息 ps:OrdinaryStrategy
 * 第二种就是 策略实现类 实现 InitializingBean 接口 afterPropertiesSet() 方法中向工厂方法主动注册自己 这种工厂方法要提供注册方法 ps:SilverStrategy
 */
@Component
@Slf4j
public class PriceStrategyFactory {

    @Autowired
    private Map<String, PriceStrategy> priceStrategyMap;

    private static Map<Integer,PriceStrategy> dataMap = Maps.newHashMap();

    public PriceStrategyFactory(){
        log.info("初始化");
    }

    public static void register(int type, SilverStrategy silverStrategy) {
        Assert.notNull(type,"type not null!");
        dataMap.put(type,silverStrategy);
    }

    @PostConstruct
    public void init() {
        for (Map.Entry<String, PriceStrategy> entry : priceStrategyMap.entrySet()) {
            //获取service实现类上注解的type
            MenberStrategyAnnotation annotation = entry.getValue().getClass().getAnnotation(MenberStrategyAnnotation.class);
            if(annotation == null){
                continue;
            }
            Integer memberType = annotation.type().getType();
            dataMap.put(memberType,entry.getValue());
        }
    }

    public static class Holder {
        public static PriceStrategyFactory instance = new PriceStrategyFactory();
    }

    public static PriceStrategyFactory getInstance() {
        return Holder.instance;
    }

    public PriceStrategy get(Integer type) {
        return dataMap.get(type);
    }
}

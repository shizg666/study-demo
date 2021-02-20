package com.shizg.study.demo.design.srategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@MenberStrategyAnnotation(type=MenberTypes.ORDINARY)
public class OrdinaryStrategy implements PriceStrategy {
    @Override
    public BigDecimal priceCompute(BigDecimal moneuy) {
        //普通会员不打折
        return moneuy;
    }

    @Override
    public int getType() {
        return MenberTypes.ORDINARY.getType();
    }
}

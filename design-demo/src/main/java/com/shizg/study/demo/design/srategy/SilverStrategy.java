package com.shizg.study.demo.design.srategy;

import com.sun.javafx.font.PrismFontFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
//@MenberStrategyAnnotation(type=MenberTypes.SILVER)
public class SilverStrategy implements PriceStrategy , InitializingBean {
    @Override
    public BigDecimal priceCompute(BigDecimal moneuy) {
        //白银会员9折
        return moneuy.multiply(new BigDecimal(0.9));
    }

    @Override
    public int getType() {
        return MenberTypes.SILVER.getType();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PriceStrategyFactory.register(getType(),this);
    }
}

package com.shizg.study.demo.design.srategy;

import java.math.BigDecimal;

public interface PriceStrategy {
    BigDecimal priceCompute(BigDecimal moneuy);

    int getType();
}

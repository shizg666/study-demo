package com.shizg.study.demo.design.srategy;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MenberStrategyAnnotation {
    MenberTypes type() ;
}

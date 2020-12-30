package com.shizg.study.demo.muit.datasource.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author
 * @version V1.0
 * @Title: DatasourceChangeAspect
 * @Description: 数据源切换切面
 * @date 2017/8/8 14:46
 */
@Aspect
public class DatasourceChangeAspect {

    /**
     * 根据注解上指定的数据源类型切换数据源
     * @param joinPoint
     * @return
     * @throws Throwable
     * @author
     * @date 2017年08月08日15:04:28
     */

    /**
     *注意方法的第二个参数RoutingWith是Spring传入的注解实例，我们根据注解的value()获取配置的key。编译前需要添加一个Maven依赖
     * <dependency>
     *     <groupId>org.springframework.boot</groupId>
     *     <artifactId>spring-boot-starter-aop</artifactId>
     * </dependency>
     */
    @Around("@annotation(anotherDatasource)")
    public Object process(ProceedingJoinPoint joinPoint, AnotherDatasource anotherDatasource) throws Throwable {
        String source = anotherDatasource.value();
        try (ContextDatasourceTypeHolder ctx = new ContextDatasourceTypeHolder(source)) {
            return joinPoint.proceed();
        }
    }

}

package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ServiceAspect {

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object watchStudentService(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        log.info("运行时参数：{}，方法签名为：{}",Arrays.toString(args) ,joinPoint.getSignature().toString());
        Object result = null;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("error exp",throwable);
        }

        log.info("执行结束；耗时：" + (System.currentTimeMillis() - startTime) + " ms");
        return result;
    }
}

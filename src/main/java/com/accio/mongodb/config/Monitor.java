package com.accio.mongodb.config;
/**
 * @author Esh
 */
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Aspect
public class Monitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Monitor.class);

    public Monitor() {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface LogExecutionTime {
    }

    /**
     *
     * @param joinPoint
     * @return Object
     * @throws Throwable
     */
    @Around("@annotation(com.accio.mongodb.config.Monitor.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();
        final long executionTime = System.currentTimeMillis() - start;

        LOGGER.info("ExecutionTime: {}ms", executionTime);
        return proceed;
    }
}

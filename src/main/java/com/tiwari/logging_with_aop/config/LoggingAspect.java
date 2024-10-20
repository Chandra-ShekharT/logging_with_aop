package com.tiwari.logging_with_aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {


    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

   @Before("execution(* com.tiwari.logging_with_aop.service..*(..))")
public void logBefore(JoinPoint joinPoint) {
    logger.info("Entering method: {} :: {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
}

@AfterReturning(pointcut = "execution(* com.tiwari.logging_with_aop.service..*(..))", returning = "result")
public void logAfter(JoinPoint joinPoint, Object result) {
    logger.info("Exiting method: {} :: {}", joinPoint.getSignature().getName(), result);
}

}


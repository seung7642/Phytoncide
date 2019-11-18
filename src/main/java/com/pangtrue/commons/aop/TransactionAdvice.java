package com.pangtrue.commons.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TransactionAdvice.class);
    
    @Pointcut("execution(public * com.pangtrue.erp..*(..))")
    private void target() {
        
    }
    
    @Around("target()")
    public Object exeTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        
        Object result = joinPoint.proceed();
        String type = joinPoint.getSignature().getDeclaringTypeName();
        
        // TODO : 트랜잭션 처리
        
        return result;
    }
}

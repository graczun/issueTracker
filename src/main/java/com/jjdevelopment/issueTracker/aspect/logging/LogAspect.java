package com.jjdevelopment.issueTracker.aspect.logging;

import static java.lang.System.currentTimeMillis;
import static java.util.Arrays.stream;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
@ConditionalOnExpression("${issueTracker.aspectLogging:true}")
public class LogAspect {

    @Around("within(@Loggable *)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        log.debug("{}::{} :> {}", joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(),
                stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(", ")));
        long timestamp = currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            log.debug("{}::{} :. ended with result [{}] in [{}] ms", joinPoint.getSignature().getDeclaringType().getSimpleName(),
                    joinPoint.getSignature().getName(), result, currentTimeMillis() - timestamp);
            return result;
        } catch (Throwable t) {
            log.debug("{}::{} :. ended with throwable [{}] in [{}] ms",
                    joinPoint.getSignature().getDeclaringType().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    t.getMessage(),
                    currentTimeMillis() - timestamp);
            throw t;
        }
    }

}

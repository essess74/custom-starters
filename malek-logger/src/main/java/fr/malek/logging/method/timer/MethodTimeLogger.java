package fr.malek.logging.method.timer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@FunctionalInterface
public interface MethodTimeLogger {
    @Around("@annotation(fr.malek.logging.annotation.Loggable)")
    Object logTimeMethod(final ProceedingJoinPoint joinPoint) throws Throwable;
}

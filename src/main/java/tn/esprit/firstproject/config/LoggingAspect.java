package tn.esprit.firstproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.firstproject.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method :" + name );
    }

    @AfterReturning("execution(* tn.esprit.firstproject.services.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Exiting method " + name );
    }

    @AfterThrowing("execution(* tn.esprit.firstproject.services.*.*(..))")
    public void logMethodException(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.error("Exception in method " + name + ": " );
    }

    @After("execution(* tn.esprit.firstproject.services.*.*(..))")
    public void logExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Exiting method " + name);
    }

}

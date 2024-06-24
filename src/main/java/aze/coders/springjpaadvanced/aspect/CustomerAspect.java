package aze.coders.springjpaadvanced.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomerAspect {
//    @Before("execution(public java.util.List<aze.coders.springjpaadvanced.model.CustomerDto> getAll())")
//    public void before() {
//        System.out.println("CustomerAspect.before");
//    }
//
//    @After("execution(public java.util.List<aze.coders.springjpaadvanced.model.CustomerDto> getAll())")
//    public void after() {
//        System.out.println("CustomerAspect.after");
//    }
    @Around("execution(public java.util.List<aze.coders.springjpaadvanced.model.CustomerDto> getAll())")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("CustomerAspect.before");
        joinPoint.proceed();
        System.out.println("CustomerAspect.after");
    }
}

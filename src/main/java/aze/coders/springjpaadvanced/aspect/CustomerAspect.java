package aze.coders.springjpaadvanced.aspect;

import org.aspectj.lang.JoinPoint;
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
    @Around("execution(public java.util.List<aze.coders.springjpaadvanced.model.*> get*())")
    public java.util.List<aze.coders.springjpaadvanced.model.CustomerDto>  around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("CustomerAspect.before");
        java.util.List<aze.coders.springjpaadvanced.model.CustomerDto> result = (java.util.List<aze.coders.springjpaadvanced.model.CustomerDto>) joinPoint.proceed();
        System.out.println("CustomerAspect.after");
        return result;
    }

    @Before("@annotation(aze.coders.springjpaadvanced.annotation.LogAnnotation)")
    public void before() {
        System.out.println("Annotation Aspect.before");
    }
}

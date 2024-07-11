package com.sample.aspects;

import com.sample.dto.UserDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Aspect
@Aspect
@Component
@Order(1)
public class LoggerAspect {
  // Joint point -> createUser() method

  // Pointcut
  @Pointcut("execution(* com.sample.controllers.UserController.createUser(..))")
  public void namePrinterPointcut() { }
  @Pointcut("execution(* com.sample..*.*(..))")
  public void logTimePointcut() { }

  // Advices
  @Around("logTimePointcut()")
  public void logTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    System.out.println("TimeLoggerAspect.logTime() for " + proceedingJoinPoint.getSignature() + " called " + startTime);
    proceedingJoinPoint.proceed();
    long timeTaken = System.currentTimeMillis() - startTime;
    System.out.println("Time taken by " + proceedingJoinPoint.getSignature() + " is " + timeTaken + "ms");
  }

  @Before("namePrinterPointcut() && args(user)")
  public void beforeNamePrinter(UserDto user) {
    System.out.println("BeforeNamePrinterAspect.beforeNamePrinter() called");
    if (user.getName() == null) throw new RuntimeException("User name should not be null");
    System.out.println("User name: " + user.getName() + " age: " + user.getAge() + " email: " + user.getEmail());
  }

}

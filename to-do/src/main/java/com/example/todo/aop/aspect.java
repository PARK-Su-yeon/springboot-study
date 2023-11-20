package com.example.todo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Slf4j
@Aspect
@Component
public class aspect {

    ///aop 되는지 확인
    @Before("execution(* com.example.todo..*(..))")
    public void doLog(JoinPoint joinPoint) {
        log.info("[aop = {}]", joinPoint.getSignature());
    }

    @Pointcut("execution(* com.example.todo..*(..))")
    private void cut(){}

    @Pointcut("execution(* com.example.todo.post.controller..*(..))")
    private void post(){}


    @After("post()")
    public void afterpost(){
            log.info("======= post controller after =============)");
    }



    @Before("cut()")
    public void beforeParameterLog(JoinPoint joinPoint) {
        Method method = getMethod(joinPoint);
        log.info("======= method name = {} =======", method.getName());

        Object[] args = joinPoint.getArgs();
        if (args.length <= 0) log.info("no parameter");
        for (Object arg : args) {
            log.info("parameter type = {}", arg.getClass().getSimpleName());
            log.info("parameter value = {}", arg);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
        Method method = getMethod(joinPoint);
        log.info("======= method name = {} =======", method.getName());
        log.info("return type = {}", returnObj.getClass().getSimpleName());
        log.info("return value = {}", returnObj);
    }

    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}

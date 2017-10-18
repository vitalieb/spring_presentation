package com.endava.aspects;


import com.endava.BoyStudent;
import com.endava.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

//@Component
@Aspect
public class NameAspect {

//    @Before("execution(* getName(..))")
    public void printSomethingBefore(){
        System.out.println("====> Something");
    }

    @Pointcut("execution(* getName(..))") // a named pointcut
    public void getNamePointcut(){}

//    @After("getNamePointcut()")
    public void willBeExecutedBefore(JoinPoint jp){
//        System.out.println(jp.getThis().getClass().getSimpleName());
        System.out.println(jp.getTarget().getClass().getSimpleName());
//        Arrays.asList(jp.getArgs()).stream().forEach(e-> System.out.println("arg: "+e));
        System.out.println("======> Before");
    }

    @Around("getNamePointcut()") // runs strange because of PrintStream that is used under the hood,
                                 // it is a buffered stream and goes to output only when filled up
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("---------> Before ProceedingJoinPoint");
        Object proceed = jp.proceed();
        System.out.println("---------> After ProceedingJoinPoint");
        return proceed;
    }

}

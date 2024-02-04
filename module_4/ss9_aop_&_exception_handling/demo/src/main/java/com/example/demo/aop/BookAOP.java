package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAOP {
    private int count;

    public BookAOP() {
        this.count = 0;
    }

    @After("execution(* com.example.demo.controller.BookController.create(..))")
    public void callAfterCreate(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.demo.controller.BookController.borrow(..))")
    public void callAfterBorrow(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.demo.controller.BookController.giveBack(..))")
    public void callAfterGiveBack(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }

    @Before("execution(* com.example.demo.controller.BookController.*(..))")
    public void countUsersAccess(){
        count++;
        System.out.println("Number of visitors: " + count);
    }
}

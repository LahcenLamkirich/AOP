package Aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecondAspect {

    @Pointcut("execution(* Main.Application.main(..))")
    public void pc1(){}

    @Before("pc1()")
    public void beforeMain(){
        System.out.println("This is the before Main using the second Aspect !");
    }

    @After("pc1()")
    public void afterMain(){
        System.out.println("This is the After Main using the second Aspect !");
    }

}

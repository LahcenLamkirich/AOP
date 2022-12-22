package Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {

    @Pointcut("execution(* Main.Application.ma(..))")
    public void pc1(){}

//    @Before("pc1()")
//    public void beforeMain(){
//        System.out.println("This is the before Main using the second Aspect !");
//    }
//
//    @After("pc1()")
//    public void afterMain(){
//        System.out.println("This is the After Main using the second Aspect !");
//    }


    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint joinPoint){
        System.out.println("This is before in second Aspect Using Around !!");
        try {
            joinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is the After in second Aspect Using Around !!");
    }
}

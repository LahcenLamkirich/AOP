package Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import sun.tools.jstat.Scale;

import java.util.Scanner;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* Main.Application.start(..))")
    public void startApplication(){}

    @Around("startApplication()")
    public void startApplicationAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Username :");
        String username = scanner.next();
        System.out.println("Enter The Password :");
        String password = scanner.next();
        if(username.equals("root") && password.equals("123456")){
            joinPoint.proceed();
        }
        else
            System.out.println("Sorry you do not have Access to the application !!");
    }

}

package Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogginAspect {

    // La duree de l'exeuction :
    Long t1, t2  ;
    @Pointcut("execution(* Metier.*.*(..))") // Toutes les methodes de Metiter :
    public void pc1(){}

    @Before("pc1()")
    public void beforeApp(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
        System.out.println("Before The execution of the Method : " + joinPoint.getSignature());
    }

    @After("pc1()")
    public void AfterApp(JoinPoint joinPoint){
        System.out.println("After The execution of the Method : " + joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        System.out.println("La durree de l'execution de la methode " + joinPoint.getSignature() + " est : " + (t2-t1));
    }
}

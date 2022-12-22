package Aspects;

import jdk.jfr.internal.jfc.model.SettingsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LogginAspect {

    Logger logger = Logger.getLogger(LogginAspect.class.getName());

    public LogginAspect() throws IOException {
        logger.addHandler(new FileHandler("logJournalisation.xml"));
        logger.setUseParentHandlers(false);
    }
    Long t1, t2  ;
    @Pointcut("execution(* Metier.*.*(..))") // Toutes les methodes de Metiter :
    public void pc1(){}

    @Before("pc1()")
    public void beforeApp(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
        logger.info("Before The execution of the Method : " + joinPoint.getSignature());
    }

    @After("pc1()")
    public void AfterApp(JoinPoint joinPoint){
        logger.info("After The execution of the Method : " + joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("La durree de l'execution de la methode " + joinPoint.getSignature() + " est : " + (t2-t1));
    }
}

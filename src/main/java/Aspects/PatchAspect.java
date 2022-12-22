package Aspects;

import Metier.Compte;
import Metier.IMetierCompteImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchAspect {

    @Pointcut("execution(* Metier.IMetierCompteImpl.retirer(..))")
    public void pc1(){}

    @Around("pc1() && args(code, montant)")
    public Object AroundRetrait(Long code, double montant , ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        IMetierCompteImpl metierCompte = (IMetierCompteImpl) joinPoint.getTarget(); // La classe de l'implementation:
        Compte compte = metierCompte.consulterCompte(code); // i get the code

        if(compte.getSolde() < montant)
            throw new RuntimeException("Solde Insufisant !!");
        return proceedingJoinPoint.proceed();
    }
}

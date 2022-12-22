package Main;

import Metier.Compte;
import Metier.IMetierCompte;
import Metier.IMetierCompteImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    public void start(){
        System.out.println("Start of application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the code of the Account :");
        Long code = scanner.nextLong();
        System.out.println("Enter the Solde of the Account :");
        double solde = scanner.nextDouble();
        IMetierCompte iMetierCompte = new IMetierCompteImpl();
        iMetierCompte.addCompte(new Compte(code, solde));

        while(true){
            try {
                System.out.println("Type de l'operation :");
                String typeOperation = scanner.next();
                System.out.println("Montant :");
                double montant = scanner.nextDouble();
                if(typeOperation.equals("q")) break;
                if(typeOperation.equals("v")){
                    iMetierCompte.verser(code,montant);
                }else if (typeOperation.equals("r")){
                    iMetierCompte.retirer(code,montant);
                }
                Compte com = iMetierCompte.consulterCompte(code);
                System.out.println("Etat de compte : " + com.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

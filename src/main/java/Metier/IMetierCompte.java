package Metier;

public interface IMetierCompte {
    void addCompte(Compte compte);
    void verser(Long code, double montant);
    void retirer(Long code, double montant);
    Compte consulterCompte(Long code);
}

package Metier;

import java.util.HashMap;
import java.util.Map;

public class IMetierCompteImpl implements IMetierCompte {

    Map<Long, Compte> comptes = new HashMap<>();

    @Override
    public void addCompte(Compte compte) {
        comptes.put(compte.getCode(), compte);
    }

    @Override
    public void verser(Long code, double montant) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() + montant);
    }

    @Override
    public void retirer(Long code, double montant) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() - montant);
    }

    @Override
    public Compte consulterCompte(Long code) {
        return comptes.get(code);
    }
}

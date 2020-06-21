package Metier.Etats;

import Metier.Automate;
import Metier.Cases.Case;
import Metier.Joueur;

import java.util.ArrayList;


//PERMET DE CALCULER LES CASES ACCESSIBLES AU JOUEUR
public class CasesAtteignables extends Etat {
    public CasesAtteignables(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        super.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {
        Joueur joueurCourant = super.getListeJoueurs().get(0);
        int des = joueurCourant.getResultLanceDes();
        joueurCourant.getPion().setListeCasesAtteignables(joueurCourant.CasePossibleAAtteindre(des));

        for(int i=0; i< joueurCourant.getPion().getListeCasesAtteignables().size(); i++)
        {
            System.out.print(joueurCourant.getPion().getListeCasesAtteignables().get(i).getNumero()+", ");
        }

    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Cases atteignables";
    }
}

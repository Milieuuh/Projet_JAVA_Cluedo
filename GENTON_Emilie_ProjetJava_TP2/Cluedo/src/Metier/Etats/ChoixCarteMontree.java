package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//PERMET AU JOUEUR DE CHOISIR LA CARTE A MONTRE
public class ChoixCarteMontree extends Etat {
    public ChoixCarteMontree(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event)
    {
        if(getAutomate().getListeJoueurs().get(0).getJoueurMontrantLaCarte().getCartesPouvantEtreMontrees().size()>1)
        {
            System.out.println("CARTE MONTREE : "+this.getAutomate().getListeJoueurs().get(0).getCarteMontree().toString());
        }

    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "ChoixCarteMontree";
    }
}

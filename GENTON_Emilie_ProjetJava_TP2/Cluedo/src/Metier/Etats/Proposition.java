package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//PERMET DE FAIRE UNE PROPOSITION
public class Proposition extends Etat {

    public Proposition(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {

        //Si je me trouve dans une case lieu
        if(this.getAutomate().getListeJoueurs().get(0).getPion().getSaCase().toString() !="Classique")
        {
            if(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().size()==3)
            {
                this.getAutomate().getListeJoueurs().get(0).setaFaitProposition(true);
            }
        }

    }

    @Override
    public Etat transition(String event) {
        Etat e=null;
        if(this.getAutomate().getListeJoueurs().get(0).getaFaitProposition()==false)
        {
            this.getAutomate().getListeJoueurs().get(0).setaFaitProposition(true);
            e= new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
        else
        {
            e =new MontrerCarte(super.getAutomate(), super.getListeJoueurs());
        }
        return e;
    }

    @Override
    public String toString() {
        return "Proposition";
    }
}

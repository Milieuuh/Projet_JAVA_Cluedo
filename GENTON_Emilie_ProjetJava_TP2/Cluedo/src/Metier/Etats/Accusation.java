package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//PERMET A UNE PERSONNE D'ACCUSER
public class Accusation extends Etat {

    public Accusation(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        this.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {

        if(this.getAutomate().getListeJoueurs().get(0).getPion().getSaCase().toString() !="Classique")
        {
            if(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().size()==3)
            {
                int compteur=0;
                for(int i = 0; i<this.getAutomate().getTalon().size(); i++)
                {
                    if(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().contains(this.getAutomate().getTalon().get(i)))
                    {
                        compteur++;
                    }
                }
                System.out.println("Compteur : "+ compteur);

                if(compteur==3)
                {
                    getAutomate().getListeJoueurs().get(0).setBonneAccusation(true);
                }
            }
        }
    }

    @Override
    public Etat transition(String event) {
        Etat e=null;
        if( getAutomate().getListeJoueurs().get(0).getBonneAccusation()==true)
        {
            e= new FinPartie(super.getAutomate(), super.getListeJoueurs());
        }
        else
        {
            e =new Perdu(super.getAutomate(), super.getListeJoueurs());
        }
        return e;
    }

    @Override
    public String toString() {
        return "Accusation";
    }
}

package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//GESTION DE LA FIN DE PARTIE
public class FinPartie extends Etat {
    public FinPartie(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        this.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {
        getAutomate().setPartieFinie(true);
        if(getListeJoueurs().get(0).getBonneAccusation()==true)
        {
            System.out.println(getAutomate().getListeJoueurs().get(0).getNom()+" a gagné.");
        }
        else
        {
            System.out.println("Pas de gagnant pour cette partie !");
        }
        getAutomate().evoluer(null);
    }

    @Override
    public Etat transition(String event) {
        return new FinPartie(getAutomate(), getListeJoueurs());
    }

    @Override
    public String toString() {
        return "FinPartie";
    }
}

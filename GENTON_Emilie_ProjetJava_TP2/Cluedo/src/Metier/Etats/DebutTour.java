package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;

//INITIALISE LE DEBUT DE TOUR DU JOUEUR
public class DebutTour extends Etat {

    public DebutTour(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        super.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {
        Joueur j = super.getListeJoueurs().get(0);
        j.setaLanceLesDes(false);
        j.setResultLanceDes(0);
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Début du Tour";
    }
}

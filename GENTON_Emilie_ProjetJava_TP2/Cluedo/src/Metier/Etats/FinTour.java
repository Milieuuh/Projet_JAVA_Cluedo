package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//GESTION DU FIN DE TOUR
public class FinTour extends  Etat {

    public FinTour(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        super.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {
        getAutomate().getListeJoueurs().get(0).setaFaitProposition(false);
        getAutomate().getListeJoueurs().get(0).setSestDeplace(false);
        getAutomate().getListeJoueurs().get(0).setaLanceLesDes(false);
        this.getAutomate().getListeJoueurs().get(0).setJoueurMontrantLaCarte(null);

        for(int i=0; i<getAutomate().getListeJoueurs().size(); i++)
        {
            this.getAutomate().getListeJoueurs().get(i).getListeCartesProposition().clear();;
            this.getAutomate().getListeJoueurs().get(i).getCartesPouvantEtreMontrees().clear();;
        }

        ArrayList<Joueur> listeJoueurs = super.getListeJoueurs();
        Joueur j = listeJoueurs.get(0);
        listeJoueurs.remove(0);
        listeJoueurs.add(j);
    }

    @Override
    public Etat transition(String event) {
        return new DebutTour(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Fin du tour";
    }
}

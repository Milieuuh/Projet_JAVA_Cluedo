package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//VERIFIE LES CHOIX POSSIBLES SUIVANT L'ACTION DU JOUEUR
public class ChoixPossibles extends Etat {

    public ChoixPossibles(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {

    }

    @Override
    public Etat transition(String event) {
        Etat e= null;
        if(event == "lancerDes"){
            e= new LancerDes(super.getAutomate(), super.getListeJoueurs());
        }else if(event=="DebutTour")
        {
            e= new DebutTour(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="FinTour")
        {
            e= new FinTour(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="Deplacement")
        {
            e= new Deplacement(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="CasesAtteignables")
        {
            e= new CasesAtteignables(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="Proposition")
        {
            e= new Proposition(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="MontrerCarte")
        {
            e= new MontrerCarte(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="ChoixCarteMontree")
        {
            e= new ChoixCarteMontree(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="Accusation")
        {
            e= new Accusation(super.getAutomate(), super.getListeJoueurs());
        }
        else if(event=="FinPartie")
        {
            e= new FinPartie(super.getAutomate(), super.getListeJoueurs());
        }
        else{
            e= new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
        return e;
    }

    @Override
    public String toString() {
        return "Choix possibles";
    }
}

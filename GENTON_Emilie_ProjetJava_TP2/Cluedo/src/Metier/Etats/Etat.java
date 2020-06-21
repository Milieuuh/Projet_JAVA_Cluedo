package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;

//CORRESPOND A TOUS LES ETATS DE L'AUTOMATE
public abstract class Etat {

    private ArrayList<Joueur> listeJoueurs;
    private Automate automate;

    public Etat(Automate automate, ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs;
        this.automate = automate;
    }


    /**
     * Permet à l'état de faire ce pour quoi il existe
     * @param event : etat
     */
    public abstract void agir(String event);

    /**
     * Permet de gérer la transition vers l'état suivant
     * @param event
     * @return
     */
    public abstract Etat transition(String event);


    /////////////////////////////////////////////////GETTER ET SETTER
    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public Automate getAutomate() {
        return automate;
    }
    public abstract String toString();

}

package Metier;

import Metier.Cartes.Carte;
import Metier.Cases.Case;
import Metier.Etats.DebutTour;
import Metier.Etats.Deplacement;
import Metier.Etats.Etat;
import Metier.Etats.LancerDes;

import java.util.ArrayList;

//PERMET DE GERER L'AUTOMATE AVEC LES ETATS
public class Automate
{
    //ATTRIBUTS
    private Etat etatCourant;
    private ArrayList<Joueur> listeJoueurs ;
    private ArrayList<Carte> listeDesCartes;

    private ArrayList<Case> listeDesCases;

    private boolean evolue = false;
    private boolean partieFinie=false;
    private ArrayList<Carte> talon;
    private ArrayList<Carte> listeCartesArme;
    private ArrayList<Carte> listeCartesSuspect;
    private ArrayList<Carte> listeCartesLieu;


    //CONSTRUCTEUR
    public Automate(ArrayList<Joueur> listeJoueurs, ArrayList<Carte> listeDesCartes, ArrayList<Carte> talon,  ArrayList<Case> listeCase,ArrayList<Carte> listeCartesArme, ArrayList<Carte> listeCartesSuspect, ArrayList<Carte> listeCartesLieu)
    {
        this.listeJoueurs= listeJoueurs;
        this.listeDesCartes = listeDesCartes;
        this.listeDesCases = listeCase;
        this.talon =talon;

        this.etatCourant = new DebutTour(this, listeJoueurs);
        System.out.println("Etat initial : "+this.etatCourant.toString());
        evoluer("");
        this.listeCartesArme = listeCartesArme;
        this.listeCartesSuspect = listeCartesSuspect;
        this.listeCartesLieu = listeCartesLieu;

    }

    /**
     * Permet de faire évoluer l'automate
     * @param event : représente l'état au l'automate va évoluer
     */
    public void evoluer(String event) {
        if (partieFinie == false) {
            System.out.println(this.etatCourant.toString()+" - - - - - - - - - - ->");
            this.etatCourant.agir(event);

            this.etatCourant = this.etatCourant.transition(event);
            System.out.println("- - - - - - - - - - - - - - - - - - - -> "+this.etatCourant.toString());


            if(evolue == true){
                evolue = false;
                this.evoluer(event);
            }
        } else {
              System.out.println("- - - - - - - - - - - - - - - - - - - ->Partie finie !!");
        }
    }

    /**
     * Permet de rechercher une arme parmi la liste des cartes
     * @param arme : libélé de la carte
     * @return la carte arme
     */
    public Carte rechercherArme(String arme)
    {
        Carte c= null;
        for(int i=0; i<this.listeCartesArme.size(); i++)
        {
            if(this.getListeCartesArme().get(i).toString()==arme)
            {
                c= this.getListeCartesArme().get(i);
            }
        }
        return c;
    }

    /**
     * Permet de rechercher un suspect parmi la liste des cartes
     * @param suspect : libélé du suspect
     * @return la carte du suspect
     */
    public Carte rechercherSuspect(String suspect)
    {
        Carte c= null;
        for(int i=0; i<this.listeCartesSuspect.size(); i++)
        {
            if(this.getListeCartesSuspect().get(i).toString()==suspect)
            {
                c= this.getListeCartesSuspect().get(i);
            }
        }
        return c;

    }

    /**
     * Permet de rechercher un lieu parmi la liste de cartes
     * @param lieu : libélé du lieu
     * @return la carte lieu
     */
    public Carte rechercherLieu(String lieu)
    {
        Carte c= null;
        for(int i=0; i<this.listeCartesLieu.size(); i++)
        {
            if(this.getListeCartesLieu().get(i).toString()==lieu )
            {
                c= this.getListeCartesLieu().get(i);
            }
        }
        return c;
    }

//////////////////////////////////////////////////////////////GETTER ET SETTER
    public boolean getEvolue() {
        return evolue;
    }

    public void setEvolue(boolean evolue) {
        this.evolue = evolue;
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }


    public ArrayList<Carte> getListeDesCartes() {
        return listeDesCartes;
    }

    public ArrayList<Case> getListeDesCases() {
        return listeDesCases;
    }


    public ArrayList<Carte> getListeCartesArme() {
        return listeCartesArme;
    }

    public ArrayList<Carte> getListeCartesSuspect() {
        return listeCartesSuspect;
    }

    public ArrayList<Carte> getListeCartesLieu() {
        return listeCartesLieu;
    }


    public ArrayList<Carte> getTalon() {
        return talon;
    }


    public void setPartieFinie(boolean partieFinie) {
        this.partieFinie = partieFinie;
    }
    public boolean getPartieFinie() {
       return this.partieFinie ;
    }


}

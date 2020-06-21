package IHM.Element;

import IHM.ComposantJeu.ZonePlateau;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Pion extends Parent {

    //ATTRIBUTS
    private ZonePlateau zonePlateau;
    private Automate automate;
    private ArrayList<Circle> pions;

    //CONSTRUCTEUR
    public Pion(Automate automate, ZonePlateau zPlateau)
    {
        this.automate=automate;
        this.zonePlateau = zPlateau;
        pions = new ArrayList<>();

        for (int j = 0; j < automate.getListeJoueurs().size(); j++) {
        for(int i=0; i< this.zonePlateau.getListeCases().size(); i++) {
                if(this.automate.getListeJoueurs().get(j).getPion().getSaCase()==this.zonePlateau.getListeCases().get(i).getCase()) {
                    pions.add(j,new Circle());
                    pions.get(j).setFill(automate.getListeJoueurs().get(j).getCouleurPion());

                    Pane depart = (Pane) zonePlateau.getListeCases().get(i);

                    pions.get(j).setRadius(10);
                    pions.get(j).setLayoutY(25);
                    pions.get(j).setStroke(Color.BLACK);
                    pions.get(j).setStrokeWidth(1);
                    pions.get(j).setLayoutX(36);

                    depart.getChildren().add(pions.get(j));
                }

            }
        }
    }

    /**
     * Permet de changer de case
     */
    public void entrerDansCase() {

        //ON ENLEVE LE PION DE LA CASE OU LE PION ETAIT AVANT LE LANCER DE DES
        this.sortirDeCase();

        // ON RECUPERE LE PANEL OU LE PIONS VA ARRIVER APRES LE LANCER DE DES
        Pane p = (Pane) zonePlateau.getListeCases().get(automate.getListeJoueurs().get(0).getPion().getSaCase().getNumero());


        if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Classique")
        {
            pions.get(0).setLayoutX(36);
            pions.get(0).setLayoutY(22);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Hall")
        {
            this.placePions(60,60);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Cuisine")
        {
            this.placePions(60,60);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Salon")
        {
            this.placePions(60,60);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Bibliotheque")
        {
            this.placePions(36,60);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Bureau")
        {
            this.placePions(60,60);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Chambre")
        {
            this.placePions(60,60);
        }
        else if(automate.getListeJoueurs().get(0).getPion().getSaCase().toString()=="Salle a manger")
        {
            this.placePions(60,60);
        }


        // ON AJOUTE A CE PANEL
        p.getChildren().add(pions.get(0));

    }

    /**
     * Permet d'enlever un pion de sa case
     */
    public void sortirDeCase() {

        Circle c = pions.get(0);
        //ON RECUPERE LE PANEL OU ETAIT LE JOUEUR ET ON LE SUPPRIME DE CE PANEL
        Pane p = (Pane) zonePlateau.getListeCases().get(automate.getListeJoueurs().get(0).getPion().getSaCase().getNumero());
        p.getChildren().remove(c);
    }


    /**
     * Permet de changer l'ordre des pions (car le joueur courant est toujours à l'index 0)
     */
    public void ChangerOrdrePion()
    {
        this.pions.add(pions.get(0));
        this.pions.remove(0);
    }

    /**
     * Positionement des pions dans pièces
     * @param laCase
     * @return
     */
    public int verifieSiPionDansPiece(Case laCase)
    {
        int compteur= 1;
        for(int i=1; i<automate.getListeJoueurs().size(); i++)
        {
            if(laCase == automate.getListeJoueurs().get(i).getPion().getSaCase())
            {
                compteur ++;
            }

        }
        return compteur;
    }

    public void placePions(int x, int y)
    {
        int nbPionDansLaMemeCase = this.verifieSiPionDansPiece(automate.getListeJoueurs().get(0).getPion().getSaCase());


        for (int i = 1; i < nbPionDansLaMemeCase; i++) {

            pions.get(0).setLayoutX(x);
            pions.get(0).setLayoutY(y);

            x+=50;

        }
    }


}

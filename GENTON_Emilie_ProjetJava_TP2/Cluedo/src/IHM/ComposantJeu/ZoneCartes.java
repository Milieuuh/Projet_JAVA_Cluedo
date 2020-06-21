package IHM.ComposantJeu;

import IHM.Cartes.FabriqueCartes;
import IHM.Cartes.VueCarte;
import IHM.Plateau.FabriqueCase;
import Metier.Automate;
import Metier.Cartes.Carte;
import Metier.Cartes.Type_Cartes;
import Metier.Joueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;

public class ZoneCartes extends Parent {

    //ATTRIBUTS
    private Automate automate;
    private Pane zoneBas;
    private ArrayList<VueCarte> listeCarteJoueur;
    private ArrayList<VueCarte> listeDeToutesLesCartes;

    //CONSTRUCTEUR
    public ZoneCartes(Automate automate)
    {
        this.automate = automate;
        this.zoneBas = new Pane();
        this.listeCarteJoueur = new ArrayList<>();
        this.listeDeToutesLesCartes = new ArrayList<>();

        zoneBas.setLayoutX(15);
        zoneBas.setLayoutY(725);

        //CARTES

        //RECTANGLE
        Rectangle rect_bas = new Rectangle() ;

        //TAILLE DU RECTANGLE ET POSITION
        rect_bas.setHeight(170);
        rect_bas.setWidth(1100);
        rect_bas.setX(15);
        rect_bas.setY(725);

        //COULEUR ET CONTOUR
        rect_bas.setFill(Color.web("#6d071a"));
        rect_bas.setStroke(Color.BLACK);


        this.getChildren().add(rect_bas);

    }


    /**
     * Permet de générer toutes les cartes du jeu
     */
    public void genererToutesLesCartes()
    {
        FabriqueCartes f = new FabriqueCartes();
        for(int i=0; i< this.automate.getListeDesCartes().size(); i++)
        {
            VueCarte c = f.FabriqueCartesDuJeu(this.automate.getListeDesCartes().get(i));
            listeDeToutesLesCartes.add(c);
        }
    }

    /**
     * Permet de générer les cartes d'un joueur précis et de les afficher
     * @param j : joueur
     */
    public void genererCartesDuJoueur(Joueur j)
    {
        this.effacerCartesDuJoueur();
        int x=25;
        for(int i=0; i< this.listeDeToutesLesCartes.size(); i++)
        {
            if(j.getListeCarte().contains(this.listeDeToutesLesCartes.get(i).getCarte()))
            {
                listeCarteJoueur.add(this.listeDeToutesLesCartes.get(i));
            }

        }

        for(int i=0; i<this.listeCarteJoueur.size(); i++)
        {
            this.listeCarteJoueur.get(i).setLayoutX(x);
            this.listeCarteJoueur.get(i).setLayoutY(10);
            zoneBas.getChildren().add(this.listeCarteJoueur.get(i));
            x+=125;
        }
        this.getChildren().add(zoneBas);
    }

    /**
     * Permet d'effacer les cartes du joueur
     */
    public void effacerCartesDuJoueur()
    {
        for(int i=0; i<listeCarteJoueur.size();i++)
        {
            zoneBas.getChildren().remove(listeCarteJoueur.get(i));
        }
        listeCarteJoueur.clear();
        this.getChildren().remove(zoneBas);
    }

////////////////////////////////////////////GETTER et SETTER
    public ArrayList<VueCarte> getListeDeToutesLesCartes() {
        return listeDeToutesLesCartes;
    }

    public Pane getZoneBas() {
        return zoneBas;
    }

    public ArrayList<VueCarte> getListeCarteJoueur() {
        return listeCarteJoueur;
    }
}

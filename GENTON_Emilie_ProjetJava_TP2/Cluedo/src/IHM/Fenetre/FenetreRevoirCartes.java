package IHM.Fenetre;

import IHM.Cartes.VueCarte;
import IHM.ComposantJeu.ZoneCartes;
import IHM.ComposantJeu.ZoneListe;
import Metier.Automate;
import Metier.Joueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

//FENETRE POUR REVOIR SON JEU DE CARTE
public class FenetreRevoirCartes extends Parent {

    private Automate automate;
    private FenetreJeu jeu ;

    public FenetreRevoirCartes(Automate automate, Stage fenetre, FenetreJeu fenetreJeu, Joueur montreur)
    {
        this.automate = automate;
        this.jeu = fenetreJeu;

        ZoneCartes z = new ZoneCartes(automate);
        z.genererToutesLesCartes();
        z.genererCartesDuJoueur(montreur);
        z.getZoneBas().setLayoutX(10);
        z.getZoneBas().setLayoutY(80);

        //////////////////////////////////////LABEL TITRE
        Button liste = new Button("VOTRE JEU");
        liste.setLayoutY(10);
        liste.setLayoutX(10);
        liste.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        liste.setTextFill(Color.WHITE);
        liste.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        liste.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));

        //BOUTON
        Button bt_ok = new Button("RETOUR");
        bt_ok.setLayoutY(275);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));

        if(z.getListeCarteJoueur().size()==8)
        {
            bt_ok.setLayoutX(400);
            fenetre.setWidth(1050);
            liste.setPrefSize(1000,50);

        }
        else if(z.getListeCarteJoueur().size()==6)
        {
            bt_ok.setLayoutX(300);
            fenetre.setWidth(850);
            liste.setPrefSize(800,50);

        }
        else if(z.getListeCarteJoueur().size()==5)
        {
            bt_ok.setLayoutX(275);
            fenetre.setWidth(750);
            liste.setPrefSize(700,50);

        }
        else if(z.getListeCarteJoueur().size()==4)
        {
            bt_ok.setLayoutX(225);
            fenetre.setWidth(600);
            liste.setPrefSize(650,50);

        }
        else if(z.getListeCarteJoueur().size()==3)
        {
            bt_ok.setLayoutX(150);
            fenetre.setWidth(500);
            liste.setPrefSize(450,50);

        }
        else if(z.getListeCarteJoueur().size()==2)
        {
            bt_ok.setLayoutX(125);
            fenetre.setWidth(400);
            liste.setPrefSize(350,50);

        }
        else if(z.getListeCarteJoueur().size()==1)
        {
            bt_ok.setLayoutX(100);
            fenetre.setWidth(300);
            liste.setPrefSize(250,50);

        }



        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                fenetre.close();

            }
        });

        //Empêche à l'utilisateur de fermer la fenêtre avec la croix
        fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });


        //AJOUT SUR L'4'ECRAN
        this.getChildren().add(liste);
        this.getChildren().add(z.getZoneBas());
        this.getChildren().add(bt_ok);
    }
}

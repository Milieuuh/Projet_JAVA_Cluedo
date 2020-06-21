package IHM.Fenetre;

import IHM.ComposantJeu.ZoneListe;
import Metier.Automate;
import Metier.InitialisationPartie;
import Metier.Joueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;

//FENETRE POUR REVOIR SA LISTE QUAND ON MONTRE UNE CARTE
public class FenetreAvoirListe extends Parent {

    private Automate automate;
    private FenetreJeu jeu ;

    public FenetreAvoirListe(Automate automate, Stage fenetre, FenetreJeu fenetreJeu, Joueur montreur)
    {
        this.automate = automate;
        this.jeu = fenetreJeu;

        ZoneListe z = new ZoneListe(automate);
        z.genererZoneListe();

        z.getZoneListeCoches().setLayoutX(60);
        z.getZoneListeCoches().setLayoutY(100);
        z.genereListeCarteCochees(montreur);

        //////////////////////////////////////LABEL TITRE
        Button liste = new Button("VOTRE LISTE");
        liste.setLayoutY(10);
        liste.setLayoutX(10);
        liste.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        liste.setTextFill(Color.WHITE);
        liste.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        liste.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        liste.setPrefSize(625,50);


        //BOUTON
        Button bt_ok = new Button("RETOUR");
        bt_ok.setLayoutX(260);
        bt_ok.setLayoutY(700);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


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
        this.getChildren().add(z);
        this.getChildren().add(bt_ok);
    }
}

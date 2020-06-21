package IHM.Fenetre;

import Metier.Automate;
import Metier.InitialisationPartie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.util.ArrayList;

//FENETRE POUR LE NOMBRE DE JOUEUR
public class FenetreInitialisationPartie extends Parent {

    public FenetreInitialisationPartie(Stage fenetre)
    {
        //////////////////////////////////////LABEL TITRE
        Button partie = new Button("NOUVELLE PARTIE");
        partie.setLayoutY(10);
        partie.setLayoutX(10);
        partie.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        partie.setTextFill(Color.WHITE);
        partie.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        partie.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        partie.setPrefSize(575,50);

        //TEXT
        Label l_nbJoueurs = new Label("Choisissez le nombre de joueurs : ");
        l_nbJoueurs.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));

        l_nbJoueurs.setLayoutX(100);
        l_nbJoueurs.setLayoutY(150);


        //COMBO BOX
        ComboBox CB_nb_adversaires = new ComboBox();
        CB_nb_adversaires.getItems().addAll(
                "2", "3", "4", "5", "6"
        );

        CB_nb_adversaires.setLayoutX(450);
        CB_nb_adversaires.setLayoutY(150);

        CB_nb_adversaires.getSelectionModel().selectFirst();

        ////////////////////////////////////BOUTON COMMENCER
        Button bt_commencer = new Button("COMMENCER");
        bt_commencer.setLayoutX(220);
        bt_commencer.setLayoutY(270);

        bt_commencer.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_commencer.setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
        bt_commencer.setPrefSize(150,25);

        bt_commencer.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Stage nouvelle_fenetre_des = new Stage();
            FenetreIntro fenetreIntro = new FenetreIntro(nouvelle_fenetre_des,Integer.valueOf((String) CB_nb_adversaires.getValue()));

            Scene nouvelle_scene = new  Scene(fenetreIntro,600,350);
            nouvelle_fenetre_des.setScene(nouvelle_scene);


            //POSITION DE LA FENETRE
            nouvelle_fenetre_des.show();

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


        //AJOUT SUR LA FENETRE
        this.getChildren().add(partie);
        this.getChildren().add(l_nbJoueurs);
        this.getChildren().add(bt_commencer);
        this.getChildren().add(CB_nb_adversaires);

    }
}

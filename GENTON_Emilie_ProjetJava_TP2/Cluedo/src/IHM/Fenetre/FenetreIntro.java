package IHM.Fenetre;

import Metier.Automate;
import Metier.InitialisationPartie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

public class FenetreIntro extends Parent {

    public FenetreIntro(Stage fenetre, int nbJoueur)
    {
        //////////////////////////////////////LABEL TITRE
        Button titre_intro = new Button("CE MATIN DANS LE JOURNAL...");
        titre_intro.setLayoutY(10);
        titre_intro.setLayoutX(10);
        titre_intro.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        titre_intro.setTextFill(Color.WHITE);
        titre_intro.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        titre_intro.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        titre_intro.setPrefSize(575,50);


        Label l_text_intro = new Label("Le Docteur Lenoir, éminent anthropologue et homme de lettre, a été retrouvé mort cette nuit. Les causes du décès restent à ce jour inconnues, mais la police a des raisons de douter d’une mort naturelle.");
        l_text_intro.setFont(Font.font("Helvetica", FontWeight.NORMAL, 18));
        l_text_intro.setMaxWidth(400);
        l_text_intro.setWrapText(true);
        l_text_intro.setMaxHeight(350);
        l_text_intro.setTextAlignment(TextAlignment.CENTER);
        l_text_intro.setLayoutX(100);
        l_text_intro.setLayoutY(120);

        //AJOUT GUILLEMETS
        URL guillemets1 = getClass().getResource("images/guillemets.png");
        Image img_guillemets1 = new Image(guillemets1.toExternalForm());
        ImageView image_view_guillements1 = new ImageView(img_guillemets1);

        image_view_guillements1.setLayoutX(50);
        image_view_guillements1.setLayoutY(105);
        image_view_guillements1.setFitWidth(40);
        image_view_guillements1.setPreserveRatio(true);

        URL guillemets2 = getClass().getResource("images/guillemets.png");
        Image img_guillemets2 = new Image(guillemets2.toExternalForm());
        ImageView image_view_guillements2 = new ImageView(img_guillemets2);

        image_view_guillements2.setLayoutX(500);
        image_view_guillements2.setLayoutY(240);
        image_view_guillements2.setRotate(180);
        image_view_guillements2.setFitWidth(40);
        image_view_guillements2.setPreserveRatio(true);


        //BOUTON
        Button bt_ok = new Button("ENQUÊTER");
        bt_ok.setLayoutX(230);
        bt_ok.setLayoutY(270);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //début initialisation automate
                InitialisationPartie initPartie= new InitialisationPartie(nbJoueur);
                Automate automate = initPartie.getAutomate();

                //création de la nouvelle fenetre
                Stage nouvelle_fenetre = new Stage();
                FenetreJeu fenetre_jeu = new FenetreJeu(nouvelle_fenetre, automate);
                Scene nouvelle_scene = new Scene(fenetre_jeu,1500,900);
                nouvelle_fenetre.setScene(nouvelle_scene);
                nouvelle_fenetre.show();
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
        this.getChildren().add(titre_intro);
        this.getChildren().add(l_text_intro);
        this.getChildren().add(bt_ok);
        this.getChildren().add(image_view_guillements1);
        this.getChildren().add(image_view_guillements2);
    }


}

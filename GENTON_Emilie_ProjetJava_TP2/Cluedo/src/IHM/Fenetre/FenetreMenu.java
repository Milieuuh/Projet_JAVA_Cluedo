package IHM.Fenetre;

import Metier.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;

//FENETRE MENU PRINCIPAL
public class FenetreMenu extends Parent {

    public FenetreMenu(Stage primaryStage)
    {
        //////////////////////////////////////LABEL TITRE
        Button cluedo = new Button("CLUEDO");
        cluedo.setLayoutY(10);
        cluedo.setLayoutX(10);
        cluedo.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 45));
        cluedo.setTextFill(Color.WHITE);
        cluedo.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        cluedo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        cluedo.setPrefSize(375,100);

        //IMAGE LOUPE
        URL loupe = getClass().getResource("images/loupe.png");
        Image img_loupe = new Image(loupe.toExternalForm());
        ImageView image_view_loupe = new ImageView(img_loupe);
        image_view_loupe.setLayoutX(25);
        image_view_loupe.setLayoutY(120);
        image_view_loupe.setFitWidth(350);
        image_view_loupe.setPreserveRatio(true);
        image_view_loupe.setRotate(-20);

        Button jouer = new Button("JOUER") ;
        Button quitter = new Button("QUITTER");

        //POSITION
        jouer.setLayoutX(125);
        jouer.setLayoutY(200);
        quitter.setLayoutX(125);
        quitter.setLayoutY(300);

        //TAILLE DES BOUTONS
        jouer.setPrefSize(150,25);
        quitter.setPrefSize(150,25);

        quitter.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        quitter.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 20));

        jouer.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        jouer.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 20));

        //SI ON CLIQUE
        quitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        jouer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //CREATION D'UNE NOUVELLE FENETRE
                Stage nouvelle_fenetre = new Stage();
                FenetreInitialisationPartie fenetre = new FenetreInitialisationPartie(nouvelle_fenetre);
                Scene nouvelle_scene = new Scene(fenetre,600,360);
                nouvelle_fenetre.setScene(nouvelle_scene);


                //ON MONTRE LA NOUVELLE FENETRE
                nouvelle_fenetre.show();

                //FERMETURE DE LA FENETRE PRECEDENTE
                primaryStage.close() ;
            }
        });

        Label l_nomPrenom = new Label("GENTON Emilie - TD1 TP2");
        l_nomPrenom.setLayoutX(115);
        l_nomPrenom.setLayoutY(450);
        l_nomPrenom.setTextFill(Color.web("#6d071a"));

        this.getChildren().add(image_view_loupe);
        this.getChildren().add(jouer);
        this.getChildren().add(quitter);
        this.getChildren().add(cluedo);
        this.getChildren().add(l_nomPrenom);
    }

}

package IHM.Fenetre.Erreur;

import IHM.Fenetre.FenetreJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreErreurTourSuivant extends Parent {

    public FenetreErreurTourSuivant(Stage fenetre, FenetreJeu jeu)
    {
        jeu.fenetreNoire();

        //////////////////////////////////////LABEL TITRE
        Button error = new Button("ATTENTION");
        error.setLayoutY(10);
        error.setLayoutX(10);
        error.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        error.setTextFill(Color.WHITE);
        error.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        error.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        error.setPrefSize(475,50);


        Label l_tour = new Label("Vous devez vous déplacer ou \n\tfaire une proposition");
        l_tour.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_tour.setLayoutX(80);
        l_tour.setLayoutY(105);

        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(170);
        bt_ok.setLayoutY(180);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                detruireCanvas(jeu.getCanvas());
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


        //AJOUT SUR L'ECRAN
        this.getChildren().add(error);
        this.getChildren().add(l_tour);
        this.getChildren().add(bt_ok);
    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}

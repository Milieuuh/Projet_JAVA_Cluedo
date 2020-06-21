package IHM.Fenetre.Erreur;

import IHM.Fenetre.FenetreJeu;
import Metier.Automate;
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

public class FenetreErreurDeplacement extends Parent {

    private Automate automate;
    private FenetreJeu fenetreJeu;

    public FenetreErreurDeplacement(Automate automate, Stage fenetre, FenetreJeu fenetreJeu)
    {
        this.automate = automate;
        this.fenetreJeu = fenetreJeu;

        fenetreJeu.fenetreNoire();

        int des = this.automate.getListeJoueurs().get(0).getResultLanceDes();

        //////////////////////////////////////LABEL TITRE
        Button attention = new Button("ATTENTION");
        attention.setLayoutY(10);
        attention.setLayoutX(10);
        attention.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        attention.setTextFill(Color.WHITE);
        attention.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        attention.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        attention.setPrefSize(475,50);


        Label l_erreur = new Label("Vous devez vous déplacer de maximun\n\t\t    "+ des+" cases. ");
        l_erreur.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_erreur.setLayoutX(36);
        l_erreur.setLayoutY(90);

        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(180);
        bt_ok.setLayoutY(180);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                detruireCanvas(fenetreJeu.getCanvas());
                fenetre.close();
                fenetreJeu.deplacement();
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
        this.getChildren().add(attention);
        this.getChildren().add(l_erreur);
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

package IHM.Fenetre;

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

//FENETRE POUR PASSER AU TOUR SUIVANT
public class FenetreTourSuivant extends Parent {

    private Automate automate;
    private FenetreJeu jeu;

    public FenetreTourSuivant(Automate automate, Stage fenetre, FenetreJeu jeu)
    {
        this.automate = automate;
        this.jeu = jeu ;

        //////////////////////////////////////LABEL TITRE
        Button TourSuivant = new Button("TOUR SUIVANT");
        TourSuivant.setLayoutY(10);
        TourSuivant.setLayoutX(10);
        TourSuivant.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        TourSuivant.setTextFill(Color.WHITE);
        TourSuivant.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        TourSuivant.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        TourSuivant.setPrefSize(475,50);

        Label l_tourSuivant = new Label("Début du tour du " + this.automate.getListeJoueurs().get(0).getNom());
        l_tourSuivant.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_tourSuivant.setLayoutX(120);
        l_tourSuivant.setLayoutY(120);

        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(180);
        bt_ok.setLayoutY(180);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                jeu.getZoneBas().genererCartesDuJoueur(automate.getListeJoueurs().get(0));
                jeu.getZoneListe().genereListeCarteCochees(automate.getListeJoueurs().get(0));

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


        this.getChildren().add(TourSuivant);
        this.getChildren().add(l_tourSuivant);
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

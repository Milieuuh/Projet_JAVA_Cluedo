package IHM.Fenetre;

import IHM.Cartes.VueCarte;
import Metier.Automate;
import Metier.Joueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//FENETRE OU LE JOUEUR REGARDE LA CARTE QU'UN AUTRE JOUEUR LUI A MONTRE
public class FenetreJoueurRegardeLaCarte extends Parent {

    private Automate automate;
    private FenetreJeu jeu;

    public FenetreJoueurRegardeLaCarte(Automate automate, Stage fenetre, FenetreJeu jeu)
    {
        this.automate=automate;
        this.jeu=jeu;


        Joueur montreur = this.automate.getListeJoueurs().get(0).getJoueurMontrantLaCarte();

        ////////////////////////////////////
        Button montreCarte = new Button("CARTE CHOISIE");
        montreCarte.setLayoutY(10);
        montreCarte.setLayoutX(10);
        montreCarte.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        montreCarte.setTextFill(Color.WHITE);
        montreCarte.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        montreCarte.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        montreCarte.setPrefSize(575,50);
        montreCarte.setText(montreCarte.getText().toUpperCase());


        //LABEL
        Label l_contenu = new Label("Le "+montreur.getNom()+" vous montre la carte :");
        l_contenu.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_contenu.setLayoutX(50);
        l_contenu.setLayoutY(95);

        for(int i=0; i<jeu.getZoneBas().getListeDeToutesLesCartes().size(); i++)
        {
            if(jeu.getZoneBas().getListeDeToutesLesCartes().get(i).getCarte() == this.automate.getListeJoueurs().get(0).getCarteMontree()) {
                jeu.getZoneBas().getListeDeToutesLesCartes().get(i).setLayoutX(250);
                jeu.getZoneBas().getListeDeToutesLesCartes().get(i).setLayoutY(140);
                this.getChildren().add(jeu.getZoneBas().getListeDeToutesLesCartes().get(i));
                jeu.getZoneBas().getListeDeToutesLesCartes().get(i).getImage().setOnMouseClicked(null);
            }
        }

        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(225);
        bt_ok.setLayoutY(310);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                fenetre.close();
                detruireCanvas(jeu.getCanvas());

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
        this.getChildren().add(montreCarte);
        this.getChildren().add(l_contenu);
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

package IHM.Fenetre;

import Metier.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//FENETRE POUR TRANSITION ENTRE LES DEUX JOUEURS : COURANT ET LE MONTREUR
public class FenetreRetourAuJoueurCourant extends Parent {
    private Automate automate;
    private FenetreJeu fenetreJeu;

    public FenetreRetourAuJoueurCourant(Automate automate, Stage fenetre, FenetreJeu fenetreJeu)
    {
        this.automate = automate;
        this.fenetreJeu = fenetreJeu;

        //////////////////////////////////////LABEL TITRE
        Button titre = new Button("AU "+automate.getListeJoueurs().get(0).getNom()+" DE JOUER");
        titre.setLayoutY(10);
        titre.setLayoutX(10);
        titre.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        titre.setTextFill(Color.WHITE);
        titre.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        titre.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        titre.setPrefSize(475,50);
        titre.setText(titre.getText().toUpperCase());


        Label l_joueurcourant = new Label("Redonner la main au "+automate.getListeJoueurs().get(0).getNom());
        l_joueurcourant.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_joueurcourant.setLayoutX(90);
        l_joueurcourant.setLayoutY(120);

        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(180);
        bt_ok.setLayoutY(180);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                fenetre.close();

                fenetreJeu.getZoneBas().genererCartesDuJoueur(automate.getListeJoueurs().get(0));
                fenetreJeu.getZoneListe().genereListeCarteCochees(automate.getListeJoueurs().get(0));

                Stage nouvelle_fenetre_joueurRegarde = new Stage();
                FenetreJoueurRegardeLaCarte fenetreJoueurRegardeLaCarte= new FenetreJoueurRegardeLaCarte(automate, nouvelle_fenetre_joueurRegarde, fenetreJeu );

                Scene nouvelle_scene = new  Scene(fenetreJoueurRegardeLaCarte,600,400);

                //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                nouvelle_fenetre_joueurRegarde.initModality(Modality.WINDOW_MODAL);
                nouvelle_fenetre_joueurRegarde.initOwner(fenetre);

                nouvelle_fenetre_joueurRegarde.setScene(nouvelle_scene);
                //POSITION DE LA FENETRE
                nouvelle_fenetre_joueurRegarde.show();


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
        this.getChildren().add(titre);
        this.getChildren().add(l_joueurcourant);
        this.getChildren().add(bt_ok);

    }
}

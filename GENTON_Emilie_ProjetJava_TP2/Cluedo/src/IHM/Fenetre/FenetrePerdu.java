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

//FENETRE PERDU
public class FenetrePerdu extends Parent
{
    private Automate automate;
    private FenetreJeu jeu;

    public FenetrePerdu(Automate automate, Stage fenetre, FenetreJeu jeu)
    {
        this.automate = automate;
        this.jeu = jeu;


        //////////////////////////////////////LABEL TITRE
        Button perdu = new Button("PERDU...");
        perdu.setLayoutY(10);
        perdu.setLayoutX(10);
        perdu.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        perdu.setTextFill(Color.WHITE);
        perdu.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        perdu.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        perdu.setPrefSize(475,50);


        Label l_gagne = new Label("Vous avez perdu... ");
        l_gagne.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_gagne.setLayoutX(100);
        l_gagne.setLayoutY(100);



        Button bt_ok = new Button("MENU PRINCIPAL");
        bt_ok.setLayoutX(180);
        bt_ok.setLayoutY(180);


        bt_ok.setPrefSize(175,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));
        if(automate.getPartieFinie()==false)
        {
            bt_ok.setText("CONTINUER");
        }

        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                if(automate.getPartieFinie()==true)
                {
                    Stage nouvelle_fenetre_principale = new Stage();
                    FenetreMenu fenetreMenu = new FenetreMenu(nouvelle_fenetre_principale);

                    Scene nouvelle_scene = new  Scene(fenetreMenu,400,500);


                    nouvelle_fenetre_principale.setScene(nouvelle_scene);
                    nouvelle_fenetre_principale.show();

                    fenetre.close();
                    jeu.getFenetreDuJeu().close();
                }
                else
                {
                    jeu.getZoneListe().effacerListeCochees();

                    jeu.getZoneBas().effacerCartesDuJoueur();
                    jeu.getZoneHaut().effacerZoneHaut();
                    jeu.getZoneHaut().genererZoneHaut();


                    jeu.getPions().ChangerOrdrePion();

                    Stage nouvelle_fenetre_tourSuivant = new Stage();
                    FenetreTourSuivant fenetreTourSuivant = new FenetreTourSuivant(automate, nouvelle_fenetre_tourSuivant, jeu );

                    Scene nouvelle_scene = new  Scene(fenetreTourSuivant,500,250);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_tourSuivant.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_tourSuivant.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_tourSuivant.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_tourSuivant.show();
                    fenetre.close();
                }

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
        this.getChildren().add(perdu);
        this.getChildren().add(l_gagne);
        this.getChildren().add(bt_ok);

    }

}

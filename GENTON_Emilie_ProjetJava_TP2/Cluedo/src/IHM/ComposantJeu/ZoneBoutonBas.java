package IHM.ComposantJeu;

import IHM.Fenetre.*;
import IHM.Fenetre.Erreur.FenetreErreurDejaLanceDe;
import IHM.Fenetre.Erreur.FenetreErreurTourSuivant;
import Metier.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ZoneBoutonBas extends Pane {

    //ATTRIBUTS
    private Automate automate;
    private Pane zoneBouton;

    //CONSTRUCTEUR
    public ZoneBoutonBas(Automate automate, FenetreJeu jeu)
    {
        this.automate = automate;
        this.zoneBouton = new Pane();

        //RECTANGLE
        Rectangle rect_bas_bouton = new Rectangle() ;

        //TAILLE DU RECTANGLE ET POSITION
        rect_bas_bouton.setHeight(170);
        rect_bas_bouton.setWidth(350);
        rect_bas_bouton.setX(1140);
        rect_bas_bouton.setY(725);

        //COULEUR ET CONTOUR
        rect_bas_bouton.setFill(Color.web("#6d071a"));
        rect_bas_bouton.setStroke(Color.BLACK);

        //BOUTONS
        Button bt_lancerDe = new Button("LANCE LE DÉ");
        bt_lancerDe.setLayoutX(1250);
        bt_lancerDe.setLayoutY(760);

        bt_lancerDe.setPrefSize(150,30);
        bt_lancerDe.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_lancerDe.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_lancerDe.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                if(automate.getListeJoueurs().get(0).getaLanceLesDes()==false) {
                    automate.evoluer("lancerDes");
                    Stage nouvelle_fenetre_des = new Stage();
                    FenetreLanceLesDes fenetreLancerDe = new FenetreLanceLesDes(automate, nouvelle_fenetre_des, jeu );

                    Scene nouvelle_scene = new  Scene(fenetreLancerDe,500,250);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_des.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_des.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_des.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_des.show();
                }
                else{
                    automate.evoluer("lancerDes");
                    jeu.fenetreNoire();
                    Stage nouvelle_fenetre_deja_de = new Stage();
                    FenetreErreurDejaLanceDe fenetreDejaLancerDe = new FenetreErreurDejaLanceDe(nouvelle_fenetre_deja_de, jeu);

                    Scene nouvelle_scene = new  Scene(fenetreDejaLancerDe,500,250);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_deja_de.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_deja_de.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_deja_de.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_deja_de.show();
                }


            }
        });


        Button bt_tour_suivant= new Button("TOUR SUIVANT");
        bt_tour_suivant.setLayoutX(1250);
        bt_tour_suivant.setLayoutY(810);

        bt_tour_suivant.setPrefSize(150,30);
        bt_tour_suivant.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_tour_suivant.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));

        bt_tour_suivant.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

            if((automate.getListeJoueurs().get(0).isSestDeplace()==true && automate.getListeJoueurs().get(0).getaLanceLesDes()==true) || automate.getListeJoueurs().get(0).getaFaitProposition()==true) {
                jeu.getZoneListe().sauvegardeItemcoches(automate.getListeJoueurs().get(0));

                automate.evoluer("FinTour");
                jeu.fenetreNoire();

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

            }else{
                Stage nouvelle_fenetre_tourSuivantErreur = new Stage();
                FenetreErreurTourSuivant fenetreTourSuivantErr = new FenetreErreurTourSuivant(nouvelle_fenetre_tourSuivantErreur, jeu );

                Scene nouvelle_scene = new  Scene(fenetreTourSuivantErr,500,250);

                //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                nouvelle_fenetre_tourSuivantErreur.initModality(Modality.WINDOW_MODAL);
                nouvelle_fenetre_tourSuivantErreur.initOwner(jeu.getFenetreDuJeu());

                nouvelle_fenetre_tourSuivantErreur.setScene(nouvelle_scene);
                //POSITION DE LA FENETRE
                nouvelle_fenetre_tourSuivantErreur.show();
            }


        }
        });


        zoneBouton.getChildren().add(rect_bas_bouton);
        zoneBouton.getChildren().add(bt_lancerDe);
        zoneBouton.getChildren().add(bt_tour_suivant);
        this.getChildren().add(zoneBouton);
    }

}

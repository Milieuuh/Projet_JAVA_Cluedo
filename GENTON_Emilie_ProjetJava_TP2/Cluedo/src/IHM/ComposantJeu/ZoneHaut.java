package IHM.ComposantJeu;

import IHM.Fenetre.*;
import IHM.Fenetre.Erreur.FenetreErreurDejaPropositionOuPasSalle;
import Metier.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ZoneHaut extends Parent {

    //ATRIBUTS
    private Automate automate;
    private Pane zoneInfosHaut;
    private FenetreJeu jeu;

    //CONSTRUCTEUR
    public ZoneHaut(Automate automate, FenetreJeu jeu)
    {
        this.automate = automate;
        this.zoneInfosHaut = new Pane();
        this.jeu = jeu;

        Rectangle rect_haut = new Rectangle() ;

        //TAILLE DU RECTANGLE ET POSITION
        rect_haut.setHeight(85);
        rect_haut.setWidth(1475);
        rect_haut.setX(15);
        rect_haut.setY(18.3);

        //COULEUR ET CONTOUR
        rect_haut.setFill(Color.web("#6d071a"));
        rect_haut.setStroke(Color.BLACK);

        zoneInfosHaut.getChildren().add(rect_haut);
        this.getChildren().add(zoneInfosHaut);
    }

    public void genererZoneHaut()
    {
        zoneInfosHaut = new Pane();
        zoneInfosHaut.setMaxWidth(1475);
        zoneInfosHaut.setMaxHeight(75);

        //ajout Couleur du joueur
        Rectangle r_couleur = new Rectangle();
        r_couleur.setHeight(50);
        r_couleur.setWidth(50);
        r_couleur.setLayoutX(30);
        r_couleur.setLayoutY(35);
        r_couleur.setStroke(Color.BLACK);
        r_couleur.setStrokeWidth(1);
        r_couleur.setFill(automate.getListeJoueurs().get(0).getCouleurPion());


        //ajout label
        Label nom = new Label("NOM : "+automate.getListeJoueurs().get(0).getNom());
        Label cluedo = new Label("CLUEDO");

        //NOM
        nom.setLayoutX(90);
        nom.setLayoutY(50);
        nom.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 20));
        nom.setTextFill(Color.WHITE);
        nom.setText(nom.getText().toUpperCase());

        //CLUEDO
        cluedo.setLayoutX(600);
        cluedo.setLayoutY(20);
        cluedo.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 55));
        cluedo.setTextFill(Color.WHITE);

        //AJOUT BOUTON
        Button bt_proposition = new Button("PROPOSITION");
        bt_proposition.setLayoutX(1100);
        bt_proposition.setLayoutY(45);

        bt_proposition.setPrefSize(150,30);
        bt_proposition.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_proposition.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));

        bt_proposition.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                if(automate.getListeJoueurs().get(0).getaFaitProposition()==false && automate.getListeJoueurs().get(0).getPion().getSaCase().toString()!="Classique") {
                    Stage nouvelle_fenetre_propo = new Stage();
                    FenetreProposition fenetreProposition = new FenetreProposition(automate, nouvelle_fenetre_propo, jeu);

                    Scene nouvelle_scene = new Scene(fenetreProposition, 650, 300);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_propo.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_propo.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_propo.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_propo.show();
                }
                else
                {
                    Stage nouvelle_fenetre_propo_erreur = new Stage();
                    FenetreErreurDejaPropositionOuPasSalle fenetrePropositionErreur = new FenetreErreurDejaPropositionOuPasSalle(automate, nouvelle_fenetre_propo_erreur, jeu);

                    Scene nouvelle_scene = new Scene(fenetrePropositionErreur, 500, 250);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_propo_erreur.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_propo_erreur.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_propo_erreur.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_propo_erreur.show();
                }
            }
        });


        Button bt_accusation = new Button("ACCUSATION");
        bt_accusation.setLayoutX(1300);
        bt_accusation.setLayoutY(45);

        bt_accusation.setPrefSize(150,30);
        bt_accusation.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_accusation.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));

        bt_accusation.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //on vérifie que le joueur courant n'a pas fait de proposition pendant le même tour et qu'il ne soit pas dans une case Classique
                if(automate.getListeJoueurs().get(0).getaFaitProposition()==false && automate.getListeJoueurs().get(0).getPion().getSaCase().toString()!="Classique") {
                    Stage nouvelle_fenetre_accusation = new Stage();
                    FenetreAccusation fenetreAccu = new FenetreAccusation(automate, nouvelle_fenetre_accusation, jeu);

                    Scene nouvelle_scene = new Scene(fenetreAccu, 650, 300);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_accusation.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_accusation.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_accusation.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_accusation.show();
                }
                else
                {
                    Stage nouvelle_fenetre_propo_erreur = new Stage();
                    FenetreErreurDejaPropositionOuPasSalle fenetrePropositionErreur = new FenetreErreurDejaPropositionOuPasSalle(automate, nouvelle_fenetre_propo_erreur, jeu);

                    Scene nouvelle_scene = new Scene(fenetrePropositionErreur, 500, 250);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_propo_erreur.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_propo_erreur.initOwner(jeu.getFenetreDuJeu());

                    nouvelle_fenetre_propo_erreur.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_propo_erreur.show();
                }

            }
        });

        zoneInfosHaut.getChildren().add(nom);
        zoneInfosHaut.getChildren().add(cluedo);
        zoneInfosHaut.getChildren().add(bt_proposition);
        zoneInfosHaut.getChildren().add(bt_accusation);
        zoneInfosHaut.getChildren().add(r_couleur);
        this.getChildren().add(zoneInfosHaut);
    }

    /**
     * Permet d'effacer la zone du haut
     */
    public void effacerZoneHaut()
    {
        this.getChildren().removeAll(zoneInfosHaut);
    }


}

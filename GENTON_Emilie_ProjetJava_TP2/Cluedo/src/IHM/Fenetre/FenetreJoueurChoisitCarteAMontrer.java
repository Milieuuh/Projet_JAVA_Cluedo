package IHM.Fenetre;

import IHM.Cartes.VueCarte;
import IHM.ComposantJeu.ZoneListe;
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

//FENETRE OU LE JOUEUR CHOISIT LA CARTE A MONTRE
public class FenetreJoueurChoisitCarteAMontrer extends Parent {

    private Automate automate;
    private FenetreJeu jeu;

    public FenetreJoueurChoisitCarteAMontrer(Automate automate, Stage fenetre, FenetreJeu jeu)
    {
        this.automate=automate;
        this.jeu=jeu;


        Joueur montreur = this.automate.getListeJoueurs().get(0).getJoueurMontrantLaCarte();

        ////////////////////////////////////
        Button montreCarte = new Button("CHOIX DE LA CARTE");
        montreCarte.setLayoutY(10);
        montreCarte.setLayoutX(10);
        montreCarte.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        montreCarte.setTextFill(Color.WHITE);
        montreCarte.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        montreCarte.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        montreCarte.setPrefSize(575,50);
        montreCarte.setText(montreCarte.getText().toUpperCase());


        //LABEL
        Label l_contenu = new Label("Cliquer sur la carte que vous voulez montrer :");
        l_contenu.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_contenu.setLayoutX(40);
        l_contenu.setLayoutY(100);


        VueCarte c=null;
        int x=100;
        for(int i=0; i<montreur.getCartesPouvantEtreMontrees().size(); i++)
        {
            final int index = i;
            for(int j=0; j<this.jeu.getZoneBas().getListeDeToutesLesCartes().size(); j++)
            {
                if(jeu.getZoneBas().getListeDeToutesLesCartes().get(j).getCarte()==montreur.getCartesPouvantEtreMontrees().get(i))
                {
                    if(montreur.getCartesPouvantEtreMontrees().size()==1)
                    {
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutX(x+150);
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutY(150);
                        this.getChildren().add(jeu.getZoneBas().getListeDeToutesLesCartes().get(j));
                        x+=125;
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).getImage().setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                automate.getListeJoueurs().get(0).setCarteMontree(montreur.getCartesPouvantEtreMontrees().get(index));
                                fenetre.close();
                                FenetreJoueurCourantAToiDeJouer();
                                automate.evoluer("ChoixCarteMontree");
                            }
                        });

                    } else if(montreur.getCartesPouvantEtreMontrees().size()==2)
                    {
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutX(x+75);
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutY(150);
                        this.getChildren().add(jeu.getZoneBas().getListeDeToutesLesCartes().get(j));
                        x+=125;
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).getImage().setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                automate.getListeJoueurs().get(0).setCarteMontree(montreur.getCartesPouvantEtreMontrees().get(index));
                                fenetre.close();
                                FenetreJoueurCourantAToiDeJouer();

                                automate.evoluer("ChoixCarteMontree");
                            }
                        });

                    }else if(montreur.getCartesPouvantEtreMontrees().size()==3)
                    {
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutX(x);
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutY(150);
                        this.getChildren().add(jeu.getZoneBas().getListeDeToutesLesCartes().get(j));
                        x+=125;
                        jeu.getZoneBas().getListeDeToutesLesCartes().get(j).getImage().setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                automate.getListeJoueurs().get(0).setCarteMontree(montreur.getCartesPouvantEtreMontrees().get(index));
                                fenetre.close();
                                FenetreJoueurCourantAToiDeJouer();
                                automate.evoluer("ChoixCarteMontree");
                            }
                        });

                    }


                }
            }
        }

        Button bt_ok = new Button("REVOIR VOTRE LISTE");
        bt_ok.setLayoutX(100);
        bt_ok.setLayoutY(340);


        bt_ok.setPrefSize(200,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                Stage nouvelle_fenetre_liste = new Stage();
                FenetreAvoirListe fenetreListe= new FenetreAvoirListe(automate, nouvelle_fenetre_liste, jeu, montreur );

                Scene nouvelle_scene = new  Scene(fenetreListe,650,750);

                //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                nouvelle_fenetre_liste.initModality(Modality.WINDOW_MODAL);
                nouvelle_fenetre_liste.initOwner(fenetre);

                nouvelle_fenetre_liste.setScene(nouvelle_scene);
                //POSITION DE LA FENETRE
                nouvelle_fenetre_liste.show();
            }
        });


        Button bt_revoirSesCartes = new Button("REVOIR VOS CARTES");
        bt_revoirSesCartes.setLayoutX(350);
        bt_revoirSesCartes.setLayoutY(340);


        bt_revoirSesCartes.setPrefSize(200,25);
        bt_revoirSesCartes.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_revoirSesCartes.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));

        bt_revoirSesCartes.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                Stage nouvelle_fenetre_carte = new Stage();
                FenetreRevoirCartes fenetreCarte= new FenetreRevoirCartes(automate, nouvelle_fenetre_carte, jeu, montreur );

                Scene nouvelle_scene = new  Scene(fenetreCarte,1000,350);

                //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                nouvelle_fenetre_carte.initModality(Modality.WINDOW_MODAL);
                nouvelle_fenetre_carte.initOwner(fenetre);

                nouvelle_fenetre_carte.setScene(nouvelle_scene);
                //POSITION DE LA FENETRE
                nouvelle_fenetre_carte.show();
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
        this.getChildren().add(bt_revoirSesCartes);
    }


    public void FenetreJoueurCourantAToiDeJouer()
    {
        Stage nouvelle_fenetre_retour = new Stage();
        FenetreRetourAuJoueurCourant fenetreRetourAuJoueurCourant = new FenetreRetourAuJoueurCourant(automate, nouvelle_fenetre_retour, jeu);

        Scene nouvelle_scene = new Scene(fenetreRetourAuJoueurCourant, 500, 250);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_retour.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_retour.initOwner(jeu.getFenetreDuJeu());

        nouvelle_fenetre_retour.setScene(nouvelle_scene);
        //POSITION DE LA FENETRE
        nouvelle_fenetre_retour.show();
    }
}

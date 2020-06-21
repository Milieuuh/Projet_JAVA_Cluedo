package IHM.Fenetre;

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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//FENETRE QUI INDIQUE SI PERSONNE N'A DE CARTES A MONTRER OU INDIQUE QUE LE JOUEUR X VA EN MONTRER UNE
public class FenetreVaMontrerCarteOUaucuneCarteAMontrer extends Parent {

    private Automate automate;
    private FenetreJeu jeu;

    public FenetreVaMontrerCarteOUaucuneCarteAMontrer(Automate automate, Stage fenetre, FenetreJeu jeu)
    {
        this.automate=automate;
        this.jeu=jeu;


        Joueur donneur = this.automate.getListeJoueurs().get(0).getJoueurMontrantLaCarte();
        Button montreCarte = new Button();
        montreCarte.setLayoutY(10);
        montreCarte.setLayoutX(10);
        montreCarte.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        montreCarte.setTextFill(Color.WHITE);
        montreCarte.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        montreCarte.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        montreCarte.setPrefSize(625,50);

        //LABEL
        Label l_contenu = new Label();
        l_contenu.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_contenu.setLayoutX(150);
        l_contenu.setLayoutY(120);

        //BOUTON OK QUI SUIVANT SI UN JOUEUR A UNE CARTE A MONTRE FAIT UNE ACTION OU UNE AUTRE
        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(270);
        bt_ok.setLayoutY(180);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        if(donneur!=null)
        {

            jeu.getZoneBas().effacerCartesDuJoueur();
            jeu.getZoneListe().sauvegardeItemcoches(this.automate.getListeJoueurs().get(0));
            jeu.getZoneListe().effacerListeCochees();
            //////////////////////////////////////LABEL TITRE
            montreCarte.setText(""+donneur.getNom()+" VA VOUS MONTRER UNE CARTE");
            montreCarte.setText(montreCarte.getText().toUpperCase());


            l_contenu.setText("Laissez la main au "+donneur.getNom());

            bt_ok.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {

                    fenetre.close();

                    Stage nouvelle_fenetre_choixCarte = new Stage();
                    FenetreJoueurChoisitCarteAMontrer fenetreChoix= new FenetreJoueurChoisitCarteAMontrer(automate, nouvelle_fenetre_choixCarte, jeu );

                    Scene nouvelle_scene = new  Scene(fenetreChoix,600,400);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_choixCarte.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_choixCarte.initOwner(fenetre);

                    nouvelle_fenetre_choixCarte.setScene(nouvelle_scene);
                    //POSITION DE LA FENETRE
                    nouvelle_fenetre_choixCarte.show();


                }
            });

        }
        else {

            montreCarte.setText("PAS DE CARTE A VOUS MONTRER");
            l_contenu.setText("Personne ne peut contrer votre hypothèse !");
            l_contenu.setLayoutX(100);

            bt_ok.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    detruireCanvas(jeu.getCanvas());
                    fenetre.close();
                }
            });

        }


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

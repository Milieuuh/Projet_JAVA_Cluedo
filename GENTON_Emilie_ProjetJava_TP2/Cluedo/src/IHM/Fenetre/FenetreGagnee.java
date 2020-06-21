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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//FENETRE JOUEUR A GAGNE
public class FenetreGagnee extends Parent
{
    private Automate automate;
    private FenetreJeu jeu;

    public FenetreGagnee(Automate automate, Stage fenetre, FenetreJeu jeu)
    {
        this.automate = automate;
        this.jeu = jeu;

        //////////////////////////////////////LABEL TITRE
        Button bravo = new Button("BRAVO !");
        bravo.setLayoutY(10);
        bravo.setLayoutX(10);
        bravo.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        bravo.setTextFill(Color.WHITE);
        bravo.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        bravo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bravo.setPrefSize(575,50);


        Label l_gagne = new Label(automate.getListeJoueurs().get(0).getNom() +" a gagné ! ");
        l_gagne.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        l_gagne.setLayoutX(185);
        l_gagne.setLayoutY(90);

        int x =100;
        for(int i=0; i<automate.getTalon().size(); i++)
        {
            for (int j = 0; j < jeu.getZoneBas().getListeDeToutesLesCartes().size(); j++)
            {
                if (jeu.getZoneBas().getListeDeToutesLesCartes().get(j).getCarte() == automate.getTalon().get(i))
                {
                    jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutX(x);
                    jeu.getZoneBas().getListeDeToutesLesCartes().get(j).setLayoutY(130);
                    this.getChildren().add(jeu.getZoneBas().getListeDeToutesLesCartes().get(j));
                    x+=125;

                }
            }
        }


        Button bt_ok = new Button("MENU PRINCIPAL");
        bt_ok.setLayoutX(220);
        bt_ok.setLayoutY(300);


        bt_ok.setPrefSize(175,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                Stage nouvelle_fenetre_principale = new Stage();
                FenetreMenu fenetreMenu = new FenetreMenu(nouvelle_fenetre_principale);

                Scene nouvelle_scene = new  Scene(fenetreMenu,400,500);


                nouvelle_fenetre_principale.setScene(nouvelle_scene);
                nouvelle_fenetre_principale.show();

                fenetre.close();
                jeu.getFenetreDuJeu().close();
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
        this.getChildren().add(bravo);
        this.getChildren().add(l_gagne);
        this.getChildren().add(bt_ok);

    }

}

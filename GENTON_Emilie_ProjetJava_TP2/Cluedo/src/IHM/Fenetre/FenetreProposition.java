package IHM.Fenetre;

import Metier.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//FENETRE POUR POPOSITION
public class FenetreProposition extends Parent {

    private Automate automate;
    private FenetreJeu fenetreJeu;

    public FenetreProposition(Automate automate, Stage fenetre, FenetreJeu fenetreJeu)
    {
        this.automate = automate;
        this.fenetreJeu = fenetreJeu;

        fenetreJeu.fenetreNoire();

        //////////////////////////////////////LABEL TITRE
        Button soupconne = new Button("JE SOUPÇONNE");
        soupconne.setLayoutY(10);
        soupconne.setLayoutX(10);
        soupconne.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 28));
        soupconne.setTextFill(Color.WHITE);
        soupconne.setBackground(new Background(new BackgroundFill( Color.web("#6d071a"),null, null)));
        soupconne.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        soupconne.setPrefSize(625,50);


        //PROPOSITION SUSPECT
        //COMBO BOX
        ComboBox CB_suspect = new ComboBox();

        CB_suspect.setLayoutX(50);
        CB_suspect.setLayoutY(125);

        //LABEL
        Label l_avec = new Label("avec");
        l_avec.setLayoutX(250);
        l_avec.setLayoutY(125);
        l_avec.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));

        //PROPOSITION ARME
        ComboBox CB_armes = new ComboBox();
        CB_armes.setLayoutX(300);
        CB_armes.setLayoutY(125);

        Label l_dans = new Label("dans " +this.automate.getListeJoueurs().get(0).getPion().getSaCase().toString());
        l_dans.setLayoutX(450);
        l_dans.setLayoutY(125);
        l_dans.setFont(Font.font("Helvetica", FontWeight.NORMAL, 20));


        //REMPLISSAGE DES COMBO BOX
        for(int i =0; i<this.automate.getListeCartesArme().size(); i++)
        {
            CB_armes.getItems().add(this.automate.getListeCartesArme().get(i).toString());
        }

        for(int i =0; i<this.automate.getListeCartesSuspect().size(); i++)
        {
            CB_suspect.getItems().add(this.automate.getListeCartesSuspect().get(i).toString());
        }

        CB_suspect.getSelectionModel().selectFirst();
        CB_armes.getSelectionModel().selectFirst();

        Button annuler = new Button("RETOUR");
        annuler.setLayoutX(140);
        annuler.setLayoutY(220);


        annuler.setPrefSize(150, 25);
        annuler.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        annuler.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));

        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                detruireCanvas(fenetreJeu.getCanvas());
                fenetre.close();
            }
        });


        Button bt_ok = new Button("PROPOSER");
        bt_ok.setLayoutX(380);
        bt_ok.setLayoutY(220);


        bt_ok.setPrefSize(150,25);
        bt_ok.setStyle("-fx-background-color: #c9ac93; -fx-border-color: black; -fx-text-fill: white;");
        bt_ok.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 16));


        bt_ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                fenetreJeu.validerProposition((String)CB_armes.getSelectionModel().getSelectedItem(), (String)CB_suspect.getSelectionModel().getSelectedItem());
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

        //AJOUT SUR L'ECRAN
        this.getChildren().add(soupconne);
        this.getChildren().add(CB_armes);
        this.getChildren().add(CB_suspect);
        this.getChildren().add(l_avec);
        this.getChildren().add(l_dans);
        this.getChildren().add(bt_ok);
        this.getChildren().add(annuler);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

}

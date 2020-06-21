package IHM.ComposantJeu;

import Metier.Automate;
import Metier.Joueur;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class ZoneListe extends Parent {

    //ATTRIBUTS
    private Automate automate;
    private Pane zoneListeCoches;
    private Rectangle rect_arme;
    private Rectangle rect_suspect;
    private Rectangle rect_lieu;
    private ArrayList<CheckBox> listeCochee;

    //CONSTRUCTEUR
    public ZoneListe(Automate automate)
    {
        this.automate = automate;
        zoneListeCoches = new Pane();
        this.listeCochee = new ArrayList<>();

        zoneListeCoches.setLayoutX(940);
        zoneListeCoches.setLayoutY(120);

        //RECTANGLE ET POSITION
        rect_arme = new Rectangle();
        rect_arme.setHeight(185);
        rect_arme.setWidth(550);
        rect_arme.setX(0);
        rect_arme.setY(0);

        rect_suspect = new Rectangle();
        rect_suspect.setHeight(185);
        rect_suspect.setWidth(550);
        rect_suspect.setX(0);
        rect_suspect.setY(200);

        rect_lieu = new Rectangle();
        rect_lieu.setHeight(187);
        rect_lieu.setWidth(550);
        rect_lieu.setX(0);
        rect_lieu.setY(400);


        //COULEUR ET CONTOUR
        rect_arme.setFill(Color.web("#c9ac93"));
        rect_arme.setStroke(Color.BLACK);

        rect_suspect.setFill(Color.web("#c9ac93"));
        rect_suspect.setStroke(Color.BLACK);

        rect_lieu.setFill(Color.web("#c9ac93"));
        rect_lieu.setStroke(Color.BLACK);

        zoneListeCoches.getChildren().add(rect_arme);
        zoneListeCoches.getChildren().add(rect_suspect);
        zoneListeCoches.getChildren().add(rect_lieu);
        this.getChildren().add(zoneListeCoches);

    }

    /**
     * Permet de générer la zone liste entière
     */
    public void genererZoneListe()
    {
        zoneListeCoches = new Pane();
        zoneListeCoches.setLayoutX(940);
        zoneListeCoches.setLayoutY(120);
        zoneListeCoches.getChildren().add(getRect_arme());
        zoneListeCoches.getChildren().add(getRect_suspect());
        zoneListeCoches.getChildren().add(getRect_lieu());

        this.genereZoneArme();
        this.genereZoneSuspect();
        this.genereZoneLieux();

        this.getChildren().add(zoneListeCoches);
    }

    /**
     * générer la Zone liste Armes
     */
    public void genereZoneArme()
    {

        this.listeCochee = new ArrayList<>();
        //ajout labels
        Label arme = new Label("ARMES");
        CheckBox poignard = new CheckBox("Poignard");
        CheckBox corde = new CheckBox("Corde");
        CheckBox chandelier = new CheckBox("Chandelier");
        CheckBox cleAnglaise = new CheckBox("Clé anglaise");
        CheckBox matraque = new CheckBox("Matraque");
        CheckBox revolver = new CheckBox("Revolver");

        listeCochee.add(poignard);
        listeCochee.add(corde);
        listeCochee.add(chandelier);
        listeCochee.add(cleAnglaise);
        listeCochee.add(revolver);
        listeCochee.add(matraque);

        //Armes
        arme.setLayoutX(200);
        arme.setLayoutY(5);
        arme.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 32));
        arme.setTextFill(Color.WHITE);

        poignard.setLayoutX(20);
        poignard.setLayoutY(60);
        poignard.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        poignard.setTextFill(Color.WHITE);

        corde.setLayoutX(20);
        corde.setLayoutY(100);
        corde.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        corde.setTextFill(Color.WHITE);

        chandelier.setLayoutX(20);
        chandelier.setLayoutY(140);
        chandelier.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        chandelier.setTextFill(Color.WHITE);

        cleAnglaise.setLayoutX(290);
        cleAnglaise.setLayoutY(60);
        cleAnglaise.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        cleAnglaise.setTextFill(Color.WHITE);

        matraque.setLayoutX(290);
        matraque.setLayoutY(100);
        matraque.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        matraque.setTextFill(Color.WHITE);

        revolver.setLayoutX(290);
        revolver.setLayoutY(140);
        revolver.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        revolver.setTextFill(Color.WHITE);

        //AJOUT
        zoneListeCoches.getChildren().add(arme);
        zoneListeCoches.getChildren().add(poignard);
        zoneListeCoches.getChildren().add(corde);
        zoneListeCoches.getChildren().add(cleAnglaise);
        zoneListeCoches.getChildren().add(matraque);
        zoneListeCoches.getChildren().add(revolver);
        zoneListeCoches.getChildren().add(chandelier);

    }

    /**
     * Générer la zone liste suspects
     */
    public void genereZoneSuspect()
    {
        //LABEL
        Label suspect = new Label("SUSPECTS");
        CheckBox rose = new CheckBox("Mademoiselle Rose");
        CheckBox moutarde = new CheckBox("Colonel Moutarde");
        CheckBox olive = new CheckBox("Révérend Olive");
        CheckBox pervenche = new CheckBox("Madame Pervenche");
        CheckBox violet = new CheckBox("Professeur Violet");
        CheckBox leblanc = new CheckBox("Madame Leblanc");

        listeCochee.add(rose);
        listeCochee.add(moutarde);
        listeCochee.add(olive);
        listeCochee.add(pervenche);
        listeCochee.add(violet);
        listeCochee.add(leblanc);


        //Suspects
        suspect.setLayoutX(180);
        suspect.setLayoutY(210);
        suspect.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 32));
        suspect.setText(suspect.getText().toUpperCase());
        suspect.setTextFill(Color.WHITE);

        rose.setLayoutX(20);
        rose.setLayoutY(260);
        rose.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        rose.setTextFill(Color.WHITE);

        moutarde.setLayoutX(20);
        moutarde.setLayoutY(300);
        moutarde.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        moutarde.setTextFill(Color.WHITE);

        pervenche.setLayoutX(20);
        pervenche.setLayoutY(340);
        pervenche.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        pervenche.setTextFill(Color.WHITE);

        olive.setLayoutX(290);
        olive.setLayoutY(260);
        olive.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        olive.setTextFill(Color.WHITE);

        violet.setLayoutX(290);
        violet.setLayoutY(300);
        violet.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        violet.setTextFill(Color.WHITE);

        leblanc.setLayoutX(290);
        leblanc.setLayoutY(340);
        leblanc.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        leblanc.setTextFill(Color.WHITE);

        zoneListeCoches.getChildren().add(suspect);
        zoneListeCoches.getChildren().add(rose);
        zoneListeCoches.getChildren().add(moutarde);
        zoneListeCoches.getChildren().add(olive);
        zoneListeCoches.getChildren().add(pervenche);
        zoneListeCoches.getChildren().add(violet);
        zoneListeCoches.getChildren().add(leblanc);
    }

    /**
     * Pemret de générer la zone liste lieux
     */
    public void genereZoneLieux()
    {

        Label lieu = new Label("LIEUX");
        CheckBox hall = new CheckBox("Hall");
        CheckBox salleAManger = new CheckBox("Salle à manger");
        CheckBox cuisine = new CheckBox("Cuisine");
        CheckBox salon = new CheckBox("Salon");
        CheckBox chambre = new CheckBox("Chambre");
        CheckBox bureau = new CheckBox("Bureau");
        CheckBox bibliotheque = new CheckBox("Bibliothèque");

        listeCochee.add(hall);
        listeCochee.add(salleAManger);
        listeCochee.add(cuisine);
        listeCochee.add(salon);
        listeCochee.add(chambre);
        listeCochee.add(bureau);
        listeCochee.add(bibliotheque);


        //lieux
        lieu.setLayoutX(210);
        lieu.setLayoutY(405);
        lieu.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 32));
        lieu.setTextFill(Color.WHITE);

        hall.setLayoutX(20);
        hall.setLayoutY(430);
        hall.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        hall.setTextFill(Color.WHITE);

        salleAManger.setLayoutX(20);
        salleAManger.setLayoutY(470);
        salleAManger.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        salleAManger.setTextFill(Color.WHITE);

        salon.setLayoutX(20);
        salon.setLayoutY(510);
        salon.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        salon.setTextFill(Color.WHITE);

        cuisine.setLayoutX(20);
        cuisine.setLayoutY(550);
        cuisine.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        cuisine.setTextFill(Color.WHITE);

        chambre.setLayoutX(290);
        chambre.setLayoutY(450);
        chambre.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        chambre.setTextFill(Color.WHITE);

        bureau.setLayoutX(290);
        bureau.setLayoutY(490);
        bureau.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        bureau.setTextFill(Color.WHITE);

        bibliotheque.setLayoutX(290);
        bibliotheque.setLayoutY(530);
        bibliotheque.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
        bibliotheque.setTextFill(Color.WHITE);


        zoneListeCoches.getChildren().add(lieu);
        zoneListeCoches.getChildren().add(salleAManger);
        zoneListeCoches.getChildren().add(hall);
        zoneListeCoches.getChildren().add(salon);
        zoneListeCoches.getChildren().add(cuisine);
        zoneListeCoches.getChildren().add(chambre);
        zoneListeCoches.getChildren().add(bureau);
        zoneListeCoches.getChildren().add(bibliotheque);
    }

    /**
     * Permet de générer la liste du joueur
     * @param j : joueur
     */
    public void genereListeCarteCochees(Joueur j)
    {
        effacerListeCochees();
        for(int i=0; i<this.listeCochee.size(); i++)
        {
            if(j.getListeCarteCochees().contains(listeCochee.get(i).getText()))
            {
                listeCochee.get(i).setSelected(true);
            }
        }

    }

    /**
     * Sauvegarde les cases cochées
     * @param j
     */
    public void sauvegardeItemcoches(Joueur j)
    {
        for(int i=0; i<this.listeCochee.size(); i++)
        {
            if(listeCochee.get(i).isSelected()==true)
            {
                j.getListeCarteCochees().add(listeCochee.get(i).getText());
            }
            else if(listeCochee.get(i).isSelected()==false && this.automate.getListeJoueurs().get(0).getListeCarteCochees().contains(listeCochee.get(i).getText()))
            {
                j.getListeCarteCochees().remove(listeCochee.get(i).getText());
            }
        }
    }

    /**
     * Permet d'effacer les cases cochées
     */
    public void effacerListeCochees()
    {
        for(int i=0; i<this.listeCochee.size(); i++)
        {
            listeCochee.get(i).setSelected(false);
        }
    }

    ////////////////////////////////////////GETTER
    public Rectangle getRect_arme() {
        return rect_arme;
    }

    public Rectangle getRect_suspect() {
        return rect_suspect;
    }

    public Rectangle getRect_lieu() {
        return rect_lieu;
    }

    public Pane getZoneListeCoches() {
        return zoneListeCoches;
    }

}

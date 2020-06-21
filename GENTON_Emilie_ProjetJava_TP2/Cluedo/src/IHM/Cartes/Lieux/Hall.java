package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Hall extends VueCarte {
    public Hall(Carte carte) {
        super(carte);

        URL CaseHall= getClass().getResource("images/hall.png");
        Image img_hall = new Image(CaseHall.toExternalForm());
        ImageView image_view_hall = new ImageView(img_hall);

        this.setLayoutY(735);
        this.setImage(image_view_hall);
        this.getChildren().add(image_view_hall);
    }

    public String toString()
    {
        return "le hall";
    }
}

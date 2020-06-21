package IHM.Cartes.Suspects;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Rose extends VueCarte {
    public Rose(Carte carte) {
        super(carte);

        URL CaseRose = getClass().getResource("images/rose.png");
        Image img_rose = new Image(CaseRose.toExternalForm());
        ImageView image_view_rose = new ImageView(img_rose);

        this.setLayoutY(735);
        this.setImage(image_view_rose);
        this.getChildren().add(image_view_rose);

    }

    public String toString()
    {
        return "Mademoiselle Rose";
    }
}

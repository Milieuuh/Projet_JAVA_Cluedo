package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Cuisine extends VueCarte {
    public Cuisine(Carte carte) {
        super(carte);

        URL CaseCuisine= getClass().getResource("images/cuisine.png");
        Image img_cuisine = new Image(CaseCuisine.toExternalForm());
        ImageView image_view_cuisine = new ImageView(img_cuisine);

        this.setLayoutY(735);
        this.setImage(image_view_cuisine);
        this.getChildren().add(image_view_cuisine);
    }

    public String toString()
    {
        return "la cuisine";
    }
}

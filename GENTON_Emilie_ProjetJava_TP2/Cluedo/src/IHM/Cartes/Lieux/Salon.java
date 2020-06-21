package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Salon extends VueCarte {
    public Salon(Carte carte) {
        super(carte);

        URL CaseSalon= getClass().getResource("images/salon.png");
        Image img_salon = new Image(CaseSalon.toExternalForm());
        ImageView image_view_salon = new ImageView(img_salon);

        this.setLayoutY(735);
        this.setImage(image_view_salon);
        this.getChildren().add(image_view_salon);
    }

    public String toString()
    {
        return "le salon";
    }
}

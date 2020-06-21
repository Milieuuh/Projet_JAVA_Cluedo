package IHM.Cartes.Armes;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Corde extends VueCarte {
    public Corde(Carte carte) {
        super(carte);

        URL CaseCorde= getClass().getResource("images/corde.png");
        Image img_corde = new Image(CaseCorde.toExternalForm());
        ImageView image_view_corde = new ImageView(img_corde);

        this.setLayoutY(735);
        this.setImage(image_view_corde);
        this.getChildren().add(image_view_corde);
    }
    public String toString()
    {
        return "la corde";
    }
}

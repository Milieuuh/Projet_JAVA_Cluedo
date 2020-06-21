package IHM.Cartes.Suspects;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Leblanc extends VueCarte {
    public Leblanc(Carte carte) {
        super(carte);

        URL CaseleBlanc= getClass().getResource("images/leblanc.png");
        Image img_leblanc = new Image(CaseleBlanc.toExternalForm());
        ImageView image_view_leblanc = new ImageView(img_leblanc);

        this.setLayoutY(735);
        this.setImage(image_view_leblanc);
        this.getChildren().add(image_view_leblanc);
    }
    public String toString()
    {
        return "Madame Leblanc";
    }
}

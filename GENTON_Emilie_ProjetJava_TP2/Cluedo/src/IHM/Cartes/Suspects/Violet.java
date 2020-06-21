package IHM.Cartes.Suspects;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Violet extends VueCarte {
    public Violet(Carte carte) {
        super(carte);

        URL CaseViolet= getClass().getResource("images/violet.png");
        Image img_violet = new Image(CaseViolet.toExternalForm());
        ImageView image_view_violet = new ImageView(img_violet);

        this.setLayoutY(735);
        this.setImage(image_view_violet);
        this.getChildren().add(image_view_violet);
    }

    public String toString()
    {
        return "Professeur Violet";
    }
}

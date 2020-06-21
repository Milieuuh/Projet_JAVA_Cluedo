package IHM.Cartes.Armes;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Matraque extends VueCarte {
    public Matraque(Carte carte) {
        super(carte);

        URL CaseMatraque = getClass().getResource("images/matraque.png");
        Image img_matraque = new Image(CaseMatraque.toExternalForm());
        ImageView image_view_matraque = new ImageView(img_matraque);

        this.setLayoutY(735);
        this.setImage(image_view_matraque);
        this.getChildren().add(image_view_matraque);
    }

    public String toString()
    {
        return "la matraque";
    }
}

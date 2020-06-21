package IHM.Cartes.Suspects;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Pervenche extends VueCarte {
    public Pervenche(Carte carte) {
        super(carte);

        URL CasePervenche= getClass().getResource("images/pervenche.png");
        Image img_pervenche = new Image(CasePervenche.toExternalForm());
        ImageView image_view_pervenche = new ImageView(img_pervenche);

        this.setLayoutY(735);
        this.setImage(image_view_pervenche);
        this.getChildren().add(image_view_pervenche);
    }

    public String toString()
    {
        return "Madame Pervenche";
    }
}

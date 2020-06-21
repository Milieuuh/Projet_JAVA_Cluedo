package IHM.Cartes.Armes;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Poignard  extends VueCarte {
    public Poignard(Carte carte) {
        super(carte);

        URL CasePoignard = getClass().getResource("images/poignard.png");
        Image img_poignard = new Image(CasePoignard.toExternalForm());
        ImageView image_view_poignard = new ImageView(img_poignard);

        this.setLayoutY(735);
        this.setImage(image_view_poignard);
        this.getChildren().add(image_view_poignard);
    }

    public String toString()
    {
        return "le poignard";
    }
}

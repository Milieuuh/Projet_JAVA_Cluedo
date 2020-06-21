package IHM.Cartes.Suspects;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Moutarde extends VueCarte {
    public Moutarde(Carte carte) {
        super(carte);

        URL CaseMoutarde= getClass().getResource("images/moutarde.png");
        Image img_moutarde = new Image(CaseMoutarde.toExternalForm());
        ImageView image_view_moutarde = new ImageView(img_moutarde);

        this.setLayoutY(735);
        this.setImage(image_view_moutarde);
        this.getChildren().add(image_view_moutarde);
    }

    @Override
    public String toString() {
        return "Colonel Moutarde";
    }
}

package IHM.Cartes.Armes;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Revolver extends VueCarte {
    public Revolver(Carte carte) {
        super(carte);

        URL CaseRevolver = getClass().getResource("images/revolver.png");
        Image img_revolver= new Image(CaseRevolver.toExternalForm());
        ImageView image_view_revolver = new ImageView(img_revolver);

        this.setLayoutY(735);
        this.setImage(image_view_revolver);
        this.getChildren().add(image_view_revolver);
    }

    public String toString()
    {
        return "le revolver";
    }
}

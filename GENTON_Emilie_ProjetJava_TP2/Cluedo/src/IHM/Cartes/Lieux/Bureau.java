package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Bureau extends VueCarte {
    public Bureau(Carte carte) {
        super(carte);

        URL CaseBureau= getClass().getResource("images/bureau.png");
        Image img_bureau = new Image(CaseBureau.toExternalForm());
        ImageView image_view_bureau = new ImageView(img_bureau);

        this.setLayoutY(735);
        this.setImage(image_view_bureau);
        this.getChildren().add(image_view_bureau);

    }

    public String toString()
    {
        return "le bureau";
    }
}

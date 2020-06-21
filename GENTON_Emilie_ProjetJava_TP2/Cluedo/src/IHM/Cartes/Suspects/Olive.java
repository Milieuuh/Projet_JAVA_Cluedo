package IHM.Cartes.Suspects;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Olive extends VueCarte {
    public Olive(Carte carte) {
        super(carte);

        URL CaseOlive= getClass().getResource("images/olive.png");
        Image img_olive = new Image(CaseOlive.toExternalForm());
        ImageView image_view_olive = new ImageView(img_olive);

        this.setLayoutY(735);
        this.setImage(image_view_olive);
        this.getChildren().add(image_view_olive);
    }
    public String toString()
    {
        return "Révérend Olive";
    }
}

package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Bibliotheque extends VueCarte {
    public Bibliotheque(Carte carte) {
        super(carte);

        URL CaseBibliotheque= getClass().getResource("images/bibliotheque.png");
        Image img_bibliotheque = new Image(CaseBibliotheque.toExternalForm());
        ImageView image_view_bibliotheque = new ImageView(img_bibliotheque);

        this.setLayoutY(735);
        this.setImage(image_view_bibliotheque);
        this.getChildren().add(image_view_bibliotheque);

    }

    public String toString()
    {
        return "la bibliotheque";
    }
}

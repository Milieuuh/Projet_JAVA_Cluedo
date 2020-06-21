package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Chambre extends VueCarte {
    public Chambre(Carte carte) {
        super(carte);

        URL CaseChambre= getClass().getResource("images/chambre.png");
        Image img_chambre = new Image(CaseChambre.toExternalForm());
        ImageView image_view_chambre = new ImageView(img_chambre);

        this.setLayoutY(735);
        this.setImage(image_view_chambre);
        this.getChildren().add(image_view_chambre);

    }

    public String toString()
    {
        return "la chambre";
    }
}

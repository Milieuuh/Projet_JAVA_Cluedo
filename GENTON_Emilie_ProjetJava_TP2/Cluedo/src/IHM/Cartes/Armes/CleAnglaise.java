package IHM.Cartes.Armes;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class CleAnglaise extends VueCarte {
    public CleAnglaise(Carte carte) {
        super(carte);

        URL CaseCle= getClass().getResource("images/cleAnglaise.png");
        Image img_cle = new Image(CaseCle.toExternalForm());
        ImageView image_view_cle = new ImageView(img_cle);

        this.setLayoutY(735);
        this.setImage(image_view_cle);
        this.getChildren().add(image_view_cle);
    }

    public String toString()
    {
        return "la clé anglaise";
    }
}

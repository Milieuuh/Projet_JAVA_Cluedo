package IHM.Cartes.Armes;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Chandelier extends VueCarte {

    public Chandelier(Carte carte) {
        super(carte);

        URL CaseChandelier= getClass().getResource("images/chandelier.png");
        Image img_chandelier = new Image(CaseChandelier.toExternalForm());
        ImageView image_view_chandelier = new ImageView(img_chandelier);

        this.setLayoutY(735);
        this.setImage(image_view_chandelier);
        this.getChildren().add(image_view_chandelier);
    }

    public String toString()
    {
        return "le chandelier";
    }
}

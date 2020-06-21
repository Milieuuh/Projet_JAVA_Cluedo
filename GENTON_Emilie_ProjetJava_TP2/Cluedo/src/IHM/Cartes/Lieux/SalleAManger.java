package IHM.Cartes.Lieux;

import IHM.Cartes.VueCarte;
import Metier.Cartes.Carte;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class SalleAManger extends VueCarte {
    public SalleAManger(Carte carte) {
        super(carte);

        URL CaseSalleAmanger= getClass().getResource("images/salleAmanger.png");
        Image img_salle_manger = new Image(CaseSalleAmanger.toExternalForm());
        ImageView image_view_salle_manger = new ImageView(img_salle_manger);

        this.setLayoutY(735);
        this.setImage(image_view_salle_manger);
        this.getChildren().add(image_view_salle_manger);
    }

    public String toString()
    {
        return "la salle à manger";
    }
}

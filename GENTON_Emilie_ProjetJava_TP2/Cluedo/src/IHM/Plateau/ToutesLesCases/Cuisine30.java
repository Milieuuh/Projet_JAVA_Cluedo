package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class Cuisine30 extends VueCase {
    public Cuisine30(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        URL CaseCuisine = getClass().getResource("images/cuisine.png");
        Image img_cuisine = new Image(CaseCuisine.toExternalForm());
        ImageView image_view_cuisine = new ImageView(img_cuisine);

        this.setLayoutX(30);
        this.setLayoutY(330);

        this.getChildren().add(image_view_cuisine);

    }

    @Override
    public String getType() {
        return "Cuisine30";
    }

}

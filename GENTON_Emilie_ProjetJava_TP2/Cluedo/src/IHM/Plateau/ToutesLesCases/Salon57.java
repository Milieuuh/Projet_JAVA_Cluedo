package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class Salon57 extends VueCase {
    public Salon57(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        URL CaseSalon = getClass().getResource("images/salon.png");
        Image img_salon = new Image(CaseSalon.toExternalForm());
        ImageView image_view_salon = new ImageView(img_salon);

        this.setLayoutX(613);
        this.setLayoutY(510);



        this.getChildren().add(image_view_salon);
    }

    @Override
    public String getType() {
        return "Salon58";
    }

}

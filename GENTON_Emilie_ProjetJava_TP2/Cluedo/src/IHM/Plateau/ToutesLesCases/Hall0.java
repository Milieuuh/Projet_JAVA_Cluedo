package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class Hall0 extends VueCase {

    public Hall0(Case caseMetier, Automate automate) {
        super(caseMetier, automate);

        URL CaseHall = getClass().getResource("images/hall.png");
        Image img_hall = new Image(CaseHall.toExternalForm());
        ImageView image_view_hall = new ImageView(img_hall);

        this.setLayoutX(30);
        this.setLayoutY(150);

        this.getChildren().add(image_view_hall);

    }

    @Override
    public String getType() {
        return "Hall0";
    }


}

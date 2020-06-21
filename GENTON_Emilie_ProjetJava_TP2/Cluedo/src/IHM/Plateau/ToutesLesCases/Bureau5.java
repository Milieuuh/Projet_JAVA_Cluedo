package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class Bureau5 extends VueCase {

    public Bureau5(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        URL CaseBureau = getClass().getResource("images/bureau.png");
        Image img_bureau = new Image(CaseBureau.toExternalForm());
        ImageView image_view_bureau = new ImageView(img_bureau);

        this.setLayoutX(614);
        this.setLayoutY(150);

        this.getChildren().add(image_view_bureau);

    }

    @Override
    public String getType() {
        return "Bureau";
    }

}

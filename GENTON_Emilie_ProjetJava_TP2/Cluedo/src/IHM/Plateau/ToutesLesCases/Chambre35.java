package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class Chambre35 extends VueCase {
    public Chambre35(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        URL CaseChambre = getClass().getResource("images/chambre.png");
        Image img_chambre = new Image(CaseChambre.toExternalForm());
        ImageView image_view_chambre = new ImageView(img_chambre);

        this.setLayoutX(614);
        this.setLayoutY(328);

        this.getChildren().add(image_view_chambre);
    }

    @Override
    public String getType() {
        return "Chambre35";
    }

}

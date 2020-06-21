package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class SalleAManger58 extends VueCase {
    public SalleAManger58(Case caseMetier, Automate automate) {
        super(caseMetier, automate);

        URL CaseSalleaManger = getClass().getResource("images/salleAManger.png");
        Image img_salle_manger = new Image(CaseSalleaManger.toExternalForm());
        ImageView image_view_salle_manger = new ImageView(img_salle_manger);

        this.setLayoutX(30);
        this.setLayoutY(555);

        this.getChildren().add(image_view_salle_manger);
    }

    @Override
    public String getType() {
        return "SalleAManger57";
    }

}

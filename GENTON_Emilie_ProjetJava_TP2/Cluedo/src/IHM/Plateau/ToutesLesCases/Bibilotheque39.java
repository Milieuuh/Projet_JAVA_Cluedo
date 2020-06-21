package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public class Bibilotheque39 extends VueCase {
    public Bibilotheque39(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        URL CaseBibliotheque = getClass().getResource("images/bibliotheque.png");
        Image img_biblio = new Image(CaseBibliotheque.toExternalForm());
        ImageView image_view_biblio = new ImageView(img_biblio);

        this.setLayoutX(395);
        this.setLayoutY(375);

        this.getChildren().add(image_view_biblio);

    }

    @Override
    public String getType() {
        return "Bibliotheque39";
    }

}

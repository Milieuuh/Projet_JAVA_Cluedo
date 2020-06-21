package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;

public abstract class Classique extends VueCase {

    private ImageView image_view_classique;

    public Classique(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        URL classique = getClass().getResource("images/classique.png");
        Image img_classique = new Image(classique.toExternalForm());
        image_view_classique = new ImageView(img_classique);
    }

    public ImageView getImage_view_classique() {
        return image_view_classique;
    }


}

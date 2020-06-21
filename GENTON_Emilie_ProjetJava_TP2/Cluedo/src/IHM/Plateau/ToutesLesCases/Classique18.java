package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique18  extends Classique {
    public Classique18(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(30);
        this.setLayoutY(285);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique18";
    }
}

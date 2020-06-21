package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique28 extends Classique {
    public Classique28(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(760);
        this.setLayoutY(285);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique28";
    }
}

package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique27 extends Classique {
    public Classique27(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(687);
        this.setLayoutY(285);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique27";
    }
}

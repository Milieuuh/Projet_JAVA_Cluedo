package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique20 extends Classique {
    public Classique20(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(176);
        this.setLayoutY(285);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique20";
    }
}

package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique50 extends Classique {
    public Classique50(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(103);
        this.setLayoutY(510);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique50";
    }
}

package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique3 extends Classique {
    public Classique3(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(468);
        this.setLayoutY(150);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique3";
    }
}

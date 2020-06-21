package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique48 extends Classique {
    public Classique48(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(833);
        this.setLayoutY(465);

        this.getChildren().add(this.getImage_view_classique());
    }

    @Override
    public String getType() {
        return "Classique48";
    }
}

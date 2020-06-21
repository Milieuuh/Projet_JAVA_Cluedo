package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique38 extends Classique {
    public Classique38(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(322);
        this.setLayoutY(420);

        this.getChildren().add(this.getImage_view_classique());
    }

    @Override
    public String getType() {
        return "Classique38";
    }
}

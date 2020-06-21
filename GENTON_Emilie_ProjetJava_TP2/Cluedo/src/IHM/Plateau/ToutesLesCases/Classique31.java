package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique31 extends Classique {
    public Classique31(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(322);
        this.setLayoutY(330);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique31";
    }
}

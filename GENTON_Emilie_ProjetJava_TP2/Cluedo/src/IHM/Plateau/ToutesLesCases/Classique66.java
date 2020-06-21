package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique66 extends Classique {
    public Classique66(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(541);
        this.setLayoutY(600);

        this.getChildren().add(this.getImage_view_classique());
    }

    @Override
    public String getType() {
        return "Classique66";
    }
}
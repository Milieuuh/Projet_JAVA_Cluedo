package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique15 extends Classique {
    public Classique15(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(687);
        this.setLayoutY(240);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique15";
    }
}

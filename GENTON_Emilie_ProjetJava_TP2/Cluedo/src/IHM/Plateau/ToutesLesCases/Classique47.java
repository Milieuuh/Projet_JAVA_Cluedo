package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique47 extends Classique {
    public Classique47(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(760);
        this.setLayoutY(465);

        this.getChildren().add(this.getImage_view_classique());
    }

    @Override
    public String getType() {
        return "Classique47";
    }
}

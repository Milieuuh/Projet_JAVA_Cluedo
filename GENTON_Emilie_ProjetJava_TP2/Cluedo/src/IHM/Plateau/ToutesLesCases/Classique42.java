package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique42 extends Classique {
    public Classique42(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(395);
        this.setLayoutY(465);

        this.getChildren().add(this.getImage_view_classique());
    }

    @Override
    public String getType() {
        return "Classique42";
    }
}

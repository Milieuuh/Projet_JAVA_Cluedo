package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique54 extends Classique {
    public Classique54(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(395);
        this.setLayoutY(510);

        this.getChildren().add(this.getImage_view_classique());

    }

    @Override
    public String getType() {
        return "Classique54";
    }
}

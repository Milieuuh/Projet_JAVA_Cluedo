package IHM.Plateau.ToutesLesCases;

import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;

public class Classique64 extends Classique {
    public Classique64(Case caseMetier, Automate automate) {
        super(caseMetier, automate);
        this.setLayoutX(395);
        this.setLayoutY(600);

        this.getChildren().add(this.getImage_view_classique());
    }

    @Override
    public String getType() {
        return "Classique64";
    }
}

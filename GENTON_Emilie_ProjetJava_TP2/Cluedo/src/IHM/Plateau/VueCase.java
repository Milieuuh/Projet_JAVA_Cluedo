package IHM.Plateau;

import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

//PERMET D'AVOIR UNE VUE SUR UNE CASE DU METIER
public abstract class VueCase extends Pane
{
    private Case caseMetier;
    private boolean estCliquee;
    private Automate automate;

    public VueCase(Case caseMetier, Automate automate)
    {
        this.caseMetier=caseMetier;
        this.automate = automate;
        estCliquee = false;

    }

    //GETTER POUR MANIPULER LES CASES
    public Case getCase(){
        return caseMetier;
    }


    //Permet de récupérer le type de la Case
    public abstract String getType() ;



    public boolean getEstCliquee() {
        return estCliquee;
    }

    public void setEstCliquee(boolean estCliquee) {
        this.estCliquee = estCliquee;
    }

}

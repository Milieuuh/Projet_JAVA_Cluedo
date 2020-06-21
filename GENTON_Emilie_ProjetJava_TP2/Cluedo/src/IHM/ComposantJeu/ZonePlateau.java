package IHM.ComposantJeu;

import IHM.Cartes.VueCarte;
import IHM.Plateau.FabriqueCase;
import IHM.Plateau.VueCase;
import Metier.Automate;
import Metier.Cases.Case;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ZonePlateau extends Parent  {

    //ATTRIBUTS
    private ArrayList<VueCase> listeCases;
    private Automate automate;


    //CONSTRUCTEUR
    public ZonePlateau(Automate automate)
    {
        this.listeCases= new ArrayList<>();
        this.automate = automate;
        FabriqueCase Fab_Case = new FabriqueCase();
        for(int i =0; i<automate.getListeDesCases().size(); i++)
        {

            VueCase c = Fab_Case.FabriqueCaseDuJeu(automate.getListeDesCases().get(i), this.automate);
            if(c!= null)
            {
                this.getChildren().add(c);
                listeCases.add(c);
            }
        }

    }

    //GETTER
    public ArrayList<VueCase> getListeCases() {
        return listeCases;
    }


}

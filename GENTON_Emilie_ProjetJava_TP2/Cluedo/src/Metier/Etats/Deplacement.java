package Metier.Etats;

import Metier.Automate;
import Metier.Cases.Case;
import Metier.Joueur;

import java.util.ArrayList;

//PERMET DE DEPLACER LE PION SUR UNE CASE VOULUE SI CETTE CASE EST ACCESSIBLE
public class Deplacement extends Etat {

    public Deplacement(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        super.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event)
    {
        Case caseVoulue = this.getAutomate().getListeJoueurs().get(0).getCaseVoulue();
        for(int i=0; i<this.getAutomate().getListeJoueurs().get(0).getPion().getListeCasesAtteignables().size(); i++)
        {
            if(this.getAutomate().getListeJoueurs().get(0).getPion().getListeCasesAtteignables().get(i)==caseVoulue)
            {
                this.getAutomate().getListeJoueurs().get(0).getPion().setSaCase(caseVoulue);
                this.getAutomate().getListeJoueurs().get(0).setSestDeplace(true);
            }
        }

        if(this.getAutomate().getListeJoueurs().get(0).isSestDeplace()==false)
        {
            System.out.println("    La case est trop loin pour vous !");
        }

    }

    @Override
    public Etat transition(String event) {
       Etat e=null;
        if(this.getAutomate().getListeJoueurs().get(0).isSestDeplace()==false)
        {
            e= new CasesAtteignables(super.getAutomate(), super.getListeJoueurs());
        }
        else
        {
            e =new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
        return e;
    }

    @Override
    public String toString() {
        return "Déplacement";
    }
}

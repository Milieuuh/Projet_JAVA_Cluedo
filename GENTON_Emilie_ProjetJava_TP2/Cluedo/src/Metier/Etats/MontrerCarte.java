package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;


//REGARDE LES CARTES QUI PEUVENT ÊTRE MONTREES
public class MontrerCarte extends Etat {

    public MontrerCarte(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {

        this.quiAQuelleCarteProposition();
        boolean plusieursChoix = false;
        boolean res = false;
        int i=1;
        while(res==false && i<getAutomate().getListeJoueurs().size())
        {

            if(getAutomate().getListeJoueurs().get(i).getCartesPouvantEtreMontrees().size()<=0)
            {
                System.out.println("Vos adversaires n'ont aucune de ces cartes !");
            }
            else
            {
                this.getListeJoueurs().get(0).setJoueurMontrantLaCarte(getAutomate().getListeJoueurs().get(i));
                if(this.getAutomate().getListeJoueurs().get(1).getCartesPouvantEtreMontrees().size()==1)
                {
                    System.out.println("MONTRE LA CARTE : "+this.getAutomate().getListeJoueurs().get(1).getCartesPouvantEtreMontrees().get(0).toString());
                    this.getAutomate().getListeJoueurs().get(0).setCarteMontree(this.getAutomate().getListeJoueurs().get(1).getCartesPouvantEtreMontrees().get(0));
                    res=true;
                }
                else  {
                    plusieursChoix=true;
                    res=true;
                }
            }
            i++;
        }
    }


    public void quiAQuelleCarteProposition()
    {
        for(int i=1; i<getAutomate().getListeJoueurs().size(); i++) {
            if (this.getAutomate().getListeJoueurs().get(i).getListeCarte().contains(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().get(0))) {
                this.getAutomate().getListeJoueurs().get(i).getCartesPouvantEtreMontrees().add(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().get(0));
            }
            if (this.getAutomate().getListeJoueurs().get(i).getListeCarte().contains(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().get(1))) {
                this.getAutomate().getListeJoueurs().get(i).getCartesPouvantEtreMontrees().add(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().get(1));
            }

            if (this.getAutomate().getListeJoueurs().get(i).getListeCarte().contains(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().get(2))) {
                this.getAutomate().getListeJoueurs().get(i).getCartesPouvantEtreMontrees().add(this.getAutomate().getListeJoueurs().get(0).getListeCartesProposition().get(2));
            }
        }
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "MontrerCarte";
    }
}

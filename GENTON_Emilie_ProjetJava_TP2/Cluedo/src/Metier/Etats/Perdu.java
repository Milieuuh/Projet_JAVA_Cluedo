package Metier.Etats;

import Metier.Automate;
import Metier.Cartes.Carte;
import Metier.Joueur;

import java.util.ArrayList;
import java.util.Collections;

//PERMET DE GERER SI UN JOUEUR PERD ET QU'IL Y A DES JOUEURS ENCORE EN JEU
public class Perdu extends Etat {

    private boolean continuePartie = false;

    public Perdu(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        this.getAutomate().setEvolue(true);
    }

    @Override
    public void agir(String event) {

        if(getAutomate().getListeJoueurs().size()>2)
        {
            continuePartie=true;
            int nbCartes = (Integer) this.getListeJoueurs().get(0).getListeCarte().size()/(this.getListeJoueurs().size()-1);
            int reste = this.getListeJoueurs().get(0).getListeCarte().size()%(this.getListeJoueurs().size()-1);
            Collections.shuffle(this.getListeJoueurs().get(0).getListeCarte());

            ArrayList<Carte> temp = this.getListeJoueurs().get(0).getListeCarte();

            for(int i=1; i<this.getListeJoueurs().size()-1; i++)
            {
                for(int j=0; j<nbCartes; j++)
                {
                    getListeJoueurs().get(i).getListeCarte().add(temp.get(j));

                }

                for(int j=0; j<nbCartes; j++)
                {
                    temp.remove(0);
                }
            }

            if(!temp.isEmpty())
            {
                for(int i=1; i<temp.size(); i++)
                {
                    this.getListeJoueurs().get(i).getListeCarte().add(temp.get(i));
                }
            }

            //SUPPRIME LE JOUEUR QUI A PERDU
            super.getListeJoueurs().remove(0);

        }
    }

    @Override
    public Etat transition(String event) {
        Etat e = null;
        if (this.continuePartie == false) {
            e = new FinPartie(super.getAutomate(), super.getListeJoueurs());
        } else {
            e = new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
        return e;
    }

    @Override
    public String toString() {
        return "Perdu";
    }
}

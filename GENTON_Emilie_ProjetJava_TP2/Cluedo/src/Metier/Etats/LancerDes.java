package Metier.Etats;

import Metier.Automate;
import Metier.Joueur;

import java.util.ArrayList;
import java.util.Random;

//PERMET AU JOUEUR DE LANCER LES DES
public class LancerDes extends Etat {

    private boolean peutSeDeplacer;

    public LancerDes(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        super.getAutomate().setEvolue(true);
        peutSeDeplacer=false;
    }

    @Override
    public void agir(String event) {
        Joueur joueurCourant = super.getListeJoueurs().get(0);

        if (joueurCourant.getaLanceLesDes() == false) {
            this.peutSeDeplacer = true;
            int de1;
            int de2;
            Random nombre = new Random();

            de1 = nombre.nextInt(6) + 1;

            joueurCourant.setResultLanceDes(de1);


            joueurCourant.setaLanceLesDes(true);

            //System.out.println("APRES DEPLACEMENT --> LancerDesJoueur : "+j.getaLanceDes());

        } else {
            this.peutSeDeplacer = false;
            System.out.println("    vous avez déjà lancé des dés");
        }
    }

    @Override
    public Etat transition (String event){
        Etat e = null;
        if (this.peutSeDeplacer == false) {
            this.peutSeDeplacer = true;
            e = new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        } else {
            e = new CasesAtteignables(super.getAutomate(), super.getListeJoueurs());
        }
        return e;
    }

    @Override
    public String toString() {
        return "Lancement des dés";
    }
}

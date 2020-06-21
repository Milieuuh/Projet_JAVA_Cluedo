package Metier.Cartes.Armes;

import Metier.Cartes.Type_Cartes;

public class Corde extends Arme {

    public Corde(Type_Cartes type) {
        super(type);
        this.setTypeArme(Type_Arme.Corde);
    }

    @Override
    public String toString() {
        return "la corde" ;
    }
}

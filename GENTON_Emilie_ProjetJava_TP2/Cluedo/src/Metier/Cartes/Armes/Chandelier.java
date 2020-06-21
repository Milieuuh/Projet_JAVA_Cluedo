package Metier.Cartes.Armes;

import Metier.Cartes.Type_Cartes;

public class Chandelier extends Arme {

    public Chandelier(Type_Cartes type) {
        super(type);
        this.setTypeArme(Type_Arme.Chandelier);
    }

    @Override
    public String toString() {
        return "le chandelier" ;
    }
}

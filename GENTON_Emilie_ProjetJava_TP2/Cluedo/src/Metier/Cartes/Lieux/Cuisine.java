package Metier.Cartes.Lieux;

import Metier.Cartes.Type_Cartes;

public class Cuisine extends Lieu {

    public Cuisine(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Cuisine);
    }

    @Override
    public String toString() {
        return "la cuisine";
    }
}

package Metier.Cartes.Lieux;

import Metier.Cartes.Type_Cartes;

public class Salon extends Lieu {

    public Salon(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Salon);
    }

    @Override
    public String toString() {
        return "le salon";
    }
}

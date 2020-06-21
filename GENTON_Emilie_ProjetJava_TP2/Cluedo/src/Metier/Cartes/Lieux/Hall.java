package Metier.Cartes.Lieux;

import Metier.Cartes.Type_Cartes;

public class Hall extends  Lieu {

    public Hall(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Hall);
    }

    @Override
    public String toString() {
        return "le hall";
    }
}

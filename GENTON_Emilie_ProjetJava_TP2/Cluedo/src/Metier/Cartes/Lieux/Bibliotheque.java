package Metier.Cartes.Lieux;

import Metier.Cartes.Type_Cartes;

public class Bibliotheque extends Lieu {
    public Bibliotheque(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Bibliotheque);
    }

    @Override
    public String toString() {
        return "la bibliotheque";
    }
}

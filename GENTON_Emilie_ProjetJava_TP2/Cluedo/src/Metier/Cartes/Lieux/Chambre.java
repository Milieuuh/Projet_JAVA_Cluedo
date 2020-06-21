package Metier.Cartes.Lieux;

import Metier.Cartes.Type_Cartes;

public class Chambre extends Lieu{

    public Chambre(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Chambre);
    }

    @Override
    public String toString() {
        return "la chambre";
    }
}

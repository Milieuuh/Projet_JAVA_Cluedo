package Metier.Cartes.Lieux;

import Metier.Cartes.Armes.Type_Arme;
import Metier.Cartes.Type_Cartes;

public class Bureau extends Lieu {

    public Bureau(Type_Cartes type) {
        super(type);
        this.setTypeLieux(Type_Lieux.Bureau);
    }

    @Override
    public String toString() {
        return "le bureau";
    }
}

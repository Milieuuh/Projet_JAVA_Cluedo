package Metier.Cartes.Suspects;

import Metier.Cartes.Type_Cartes;

public class Moutarde extends  Suspect {

    public Moutarde(Type_Cartes type) {
        super(type);
        this.setTypeSuspect(Type_Suspects.Moutarde);
    }

    @Override
    public String toString() {
        return "Colonel Moutarde";
    }
}

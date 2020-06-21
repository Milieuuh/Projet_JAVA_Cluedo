package Metier.Cartes.Suspects;

import Metier.Cartes.Type_Cartes;

public class Rose extends Suspect {

    private Type_Suspects typeSuspect;

    public Rose(Type_Cartes type) {
        super(type);
        this.setTypeSuspect(Type_Suspects.Rose);
    }

    @Override
    public String toString() {
        return "Mademoiselle Rose";
    }
}

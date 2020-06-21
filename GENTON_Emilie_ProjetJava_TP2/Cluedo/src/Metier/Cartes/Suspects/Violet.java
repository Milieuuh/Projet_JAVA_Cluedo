package Metier.Cartes.Suspects;

import Metier.Cartes.Type_Cartes;

public class Violet extends Suspect {

    private Type_Suspects typeSuspect;

    public Violet(Type_Cartes type) {
        super(type);
        this.setTypeSuspect(Type_Suspects.Violet);
    }

    @Override
    public String toString() {
        return "Professeur Violet";
    }
}

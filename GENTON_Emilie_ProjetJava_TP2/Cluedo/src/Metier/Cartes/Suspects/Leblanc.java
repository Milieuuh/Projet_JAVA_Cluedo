package Metier.Cartes.Suspects;

import Metier.Cartes.Type_Cartes;

public class Leblanc extends Suspect {

    public Leblanc(Type_Cartes type) {
        super(type);
        this.setTypeSuspect(Type_Suspects.Leblanc);
    }

    @Override
    public String toString() {
        return "Madame LeBlanc";
    }
}

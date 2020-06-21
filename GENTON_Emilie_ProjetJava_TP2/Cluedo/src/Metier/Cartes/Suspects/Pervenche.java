package Metier.Cartes.Suspects;

import Metier.Cartes.Type_Cartes;

public class Pervenche extends Suspect
{
    private Type_Suspects typeSuspect;

    public Pervenche(Type_Cartes type) {
        super(type);
        this.setTypeSuspect(Type_Suspects.Pervenche);
    }

    @Override
    public String toString() {
        return "Madame Pervenche";
    }
}

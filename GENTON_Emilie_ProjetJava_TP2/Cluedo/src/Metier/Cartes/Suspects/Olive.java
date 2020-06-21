package Metier.Cartes.Suspects;

import Metier.Cartes.Type_Cartes;

public class Olive extends Suspect {


    public Olive(Type_Cartes type) {
        super(type);
        this.setTypeSuspect(Type_Suspects.Olive);
    }

    @Override
    public String toString() {
        return "Révérend Olive";
    }
}

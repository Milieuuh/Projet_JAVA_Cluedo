package Metier.Cartes.Armes;

import Metier.Cartes.Type_Cartes;

public class Revolver extends Arme {

    public Revolver(Type_Cartes type) {
        super(type);
        setTypeArme(Type_Arme.Revolver);
    }

    @Override
    public String toString() {
        return "le revolver";
    }
}

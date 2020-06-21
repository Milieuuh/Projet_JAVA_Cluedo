package Metier.Cartes.Armes;

import Metier.Cartes.Type_Cartes;

public class Matraque extends Arme {

    public Matraque(Type_Cartes type) {
        super(type);
        setTypeArme(Type_Arme.Matraque);
    }

    @Override
    public String toString() {
        return "la matraque";
    }
}
